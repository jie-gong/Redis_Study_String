package com.gong_redis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gong_redis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author:
 * @Project: JavaLaity
 * @Pcakage: com.gong_redis.mapper.UserMapper
 * @Date: 2022年10月05日 11:22
 * @Description:
 */
@Mapper
@Repository
//持久层框架
public interface UserMapper extends BaseMapper<User> {
}
