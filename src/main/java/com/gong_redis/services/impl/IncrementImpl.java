package com.gong_redis.services.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.gong_redis.entity.Increment;
import com.gong_redis.mapper.IncrementMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author:
 * @Project: JavaLaity
 * @Pcakage: com.gong_redis.services.impl.IncrementImpl
 * @Date: 2022年10月07日 09:20
 * @Description:
 */
@Service
public class IncrementImpl {
    @Autowired
    private IncrementMapper incrementMapper;

    //id不同插入数据库
    public void insert(String act, String view) {
        Increment increment = new Increment();
        increment.setAct(act);
        increment.setView(view);
        incrementMapper.insert(increment);
    }

    //id相同更新数据库
    public void update(Integer id, String act, String view) {

        Increment increment = new Increment();
        increment.setId(id);
        increment.setAct(act);
        increment.setView(view);
        incrementMapper.updateById(increment);
    }


}
