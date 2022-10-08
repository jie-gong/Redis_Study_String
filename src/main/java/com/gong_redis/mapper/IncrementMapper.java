package com.gong_redis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gong_redis.entity.Increment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong_redis.mapper.IncermentMapper
 * @Date: 2022年10月07日 09:19
 * @Description:
 */
@Mapper
@Repository
public interface IncrementMapper extends BaseMapper<Increment> {
}
