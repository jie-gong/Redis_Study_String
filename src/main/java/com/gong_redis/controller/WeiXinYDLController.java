package com.gong_redis.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gong_redis.entity.Increment;
import com.gong_redis.mapper.IncrementMapper;
import com.gong_redis.services.impl.IncrementImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @author:
 * @Project: JavaLaity
 * @Pcakage: com.gong_redis.controller.WeiXinYYLCOntrlooer
 * @Date: 2022年10月07日 08:27
 * @Description:
 */

//微信阅读量
@Api(description = "微信阅读量实现")
@RestController
public class WeiXinYDLController {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @ApiOperation("添加一次阅读量")
    @GetMapping("/insert")
    public void Insert(Integer id) {
        String key = "article" + id;
        Long increment = stringRedisTemplate.opsForValue().increment(key);
        System.out.println(key + "阅读量为" + increment);
    }

    @ApiOperation("减少一次阅读量")
    @GetMapping("/deleteOne")
    public void deleteOne(Integer id) {
        String key = "article" + id;
        Long increment = stringRedisTemplate.opsForValue().decrement(key);
        System.out.println(key + "阅读量为" + increment);
    }

    @ApiOperation("查询当前缓存")
    @GetMapping("/select")
    public void Select(Integer id) {
        String key = "article" + id;
        String s = stringRedisTemplate.opsForValue().get(key);
        System.out.println("当前数据为" + s);
    }

    @Autowired
    private IncrementImpl increment;
    @Autowired
    private IncrementMapper incrementMapper;

    @ApiOperation("插入或更新数据")
    @GetMapping(value = "/insertOrupdate")
    public void InsertOrUpdate(Integer id) {
        String key = "article" + id;
        QueryWrapper<Increment> incrementQueryWrapper = new QueryWrapper<>();
        incrementQueryWrapper.eq("act", key);
        Increment increment1 = incrementMapper.selectOne(incrementQueryWrapper);
        //判断数据库是否存在数据 执行插入操作
        if (increment1 == null) {
            stringRedisTemplate.opsForValue().increment(key);
            String s = stringRedisTemplate.opsForValue().get(key);
            this.increment.insert(key, s);
            System.out.println("插入成功");
        }
        //数据库存在数据 执行更新操作
        else {
            QueryWrapper<Increment> incrementQueryWrapper2 = new QueryWrapper<>();
            incrementQueryWrapper2.eq("id", id);
            Increment increment01 = incrementMapper.selectOne(incrementQueryWrapper);
            int id1 = increment01.getId();
            stringRedisTemplate.opsForValue().increment(key);
            String s = stringRedisTemplate.opsForValue().get(key);
            this.increment.update(id1, key, s);
            System.out.println("更新成功");
        }
    }
}
