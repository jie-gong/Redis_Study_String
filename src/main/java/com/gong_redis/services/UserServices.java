package com.gong_redis.services;

import com.gong_redis.controller.UserVo;
import com.gong_redis.entity.User;
import com.gong_redis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author:
 * @Project: JavaLaity
 * @Pcakage: com.gong_redis.services.UserServices
 * @Date: 2022年10月05日 11:22
 * @Description:
 */
@Service
@CacheConfig(cacheNames = {"user"})
public class UserServices {
    @Autowired
    private UserMapper userMapper;

    //存储数据到redis————存储一个对象
    //@Cacheable(key = "#id")中key为数据库中id的字段名
    //用过id来查找数据库，然后将获取的一个对象存入redis缓存中
    @Cacheable(key = "#id")
    public User findUserById(int id) {
        return userMapper.selectById(id);
    }

    //删除数据————删除redis的一个对象
    //@CacheEvict(key = "#id")中key为数据库中id的字段名
    //通过id来删除redis缓存中的数据
    @CacheEvict(key = "#id")
    public void deleteUser(int id) {
        User user = new User();
        user.setId(id);
        userMapper.deleteById(id);
    }

    //更新数据————更新redis中一个对象的数据
    //@CachePut(key = "#user.getId()")中key为获取实体类中的id属性
    //通过id来修改redis缓存中的数据
    @CachePut(key = "#user.getId()")
    public User upDateUser(User user) {
        userMapper.updateById(user);
        User user1 = userMapper.selectById(user.getId());
        return user1;
    }

}

