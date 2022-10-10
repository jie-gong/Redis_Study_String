package com.gong_redis.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gong_redis.entity.User;
import com.gong_redis.mapper.UserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

/**
 * @author:
 * @Project: JavaLaity
 * @Pcakage: com.gong_redis.controller.UserController
 * @Date: 2022年10月05日 11:21
 * @Description:
 */
@Api(description = "用户接口")
@RestController
@RequestMapping("/user")
public class UserController {
    private static final String CACHE_KEY_USER = "user:";
    @Autowired
    private UserMapper userMapper;

    @Resource
    private RedisTemplate redisTemplate;

    @ApiOperation("数据库初始化一百条数据")
    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public void init() {
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            User user = new User();
            String s = "un" + i;
            user.setName(s);
            user.setAge(s);
            int i1 = random.nextInt(2);
            user.setSex(i1);
            userMapper.insert(user);
            //缓存key
            List<User> users = userMapper.selectList(new QueryWrapper<>());
            String key = CACHE_KEY_USER + users.get(i).getId();
            System.out.println(key);
            //到数据库里面，重新捞出新数据出来 做缓存
//            user = this.userMapper.selectById(user.getId());

            //opsForValue代表了redis的String数据结构
            //这个set代表了redis的set命令
//            users.forEach(System.out::println);
            redisTemplate.opsForValue().set(key, users);
        }
    }

    @ApiOperation("修改某条数据")
    @PostMapping(value = "/updateUser")
    public void updateUser(@RequestBody User user) {
        User user1 = new User();
        BeanUtils.copyProperties(user, user1);
        //先修改数据库
        userMapper.updateById(user1);
        String key = CACHE_KEY_USER + user.getId();
        //再修改缓存
        //修改使用set命令重新设置 redis没有update操作 ，都是重新设置新值
        redisTemplate.opsForValue().set(key, user);
    }


    @ApiOperation("根据id查询数据")
    @RequestMapping(value = "/findBid/{id}", method = RequestMethod.GET)
    public Object findById(@PathVariable("id") int id) {
//        ValueOperations<String, User> operations = redisTemplate.opsForValue();
        String key = CACHE_KEY_USER + id;
        Object user2 = redisTemplate.opsForValue().get(key);
//        Object user2 = operations.get(key);

        if (user2 == null) {
            System.out.println("查询数据库");
            User user = userMapper.selectById(id);
            redisTemplate.opsForValue().set(key, user);
            return user;
        } else {
            Object o = redisTemplate.opsForValue().get(key);
//            System.out.println(user3);
            System.out.println("查询缓存");
            return o;
        }
    }

}
