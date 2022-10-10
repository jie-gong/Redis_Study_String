package com.gong_redis.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * @author:
 * @Project: JavaLaity
 * @Pcakage: com.gong_redis.entity.Increment
 * @Date: 2022年10月07日 09:16
 * @Description:
 */
@Data
public class Increment implements Serializable {
    @TableField("id")
    private int id;
    @TableField("act")
    private String act;
    @TableField("view")
    private String view;
}
