package com.gong_redis.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gong_redis.entity.User;
import com.gong_redis.mapper.UserMapper;
import com.gong_redis.services.UserServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong_redis.controller.UserController
 * @Date: 2022年10月05日 11:21
 * @Description:
 */
@Api("SpringCache测试")
@RestController
@RequestMapping("/cache")
public class SpringCacheController {
    @Autowired
    UserServices userServices;


    @ApiOperation("根据id查询数据")
    @RequestMapping(value = "/findBid/{id}", method = RequestMethod.GET)
    public Object findById(@PathVariable("id") int id) {
        User userById = userServices.findUserById(id);
        System.out.println("查询成功");
        return userById;
    }


    @ApiOperation("按id删除数据")
    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
    public void deleteUser(@PathVariable("id") int id) {
        userServices.deleteUser(id);
    }


    @ApiOperation("更新缓存数据")
    @PostMapping(value = "/updateUser")
    public void up(@RequestBody User user) {

//        UserVo user1 = new UserVo();
//        //同类之间不同对象要求进行数据复制
//        BeanUtils.copyProperties();
//        System.out.println("1111111====================="+user1.toString());
        userServices.upDateUser(user);
    }
}
