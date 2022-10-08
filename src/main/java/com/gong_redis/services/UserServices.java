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
 * @author: 公杰
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

    @Cacheable(key = "#id")
    public User findUserById(int id) {
        return userMapper.selectById(id);
    }

    @CacheEvict(key = "#id")
    public void deleteUser(int id){
        User user = new User();
        user.setId(id);
        userMapper.deleteById(id);
    }
    @CachePut(key = "#user.getId()")
    public User upDateUser(User user) {
        userMapper.updateById(user);
        User user1 = userMapper.selectById(user.getId());
        return user1;
    }

}

