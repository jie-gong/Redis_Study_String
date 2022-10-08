package com.gong_redis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.io.Serializable;

/**
 * @author: 公杰
 * @Project: JavaLaity
 * @Pcakage: com.gong_redis.entity.User
 * @Date: 2022年10月05日 14:47
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private int id;

    @TableField("name")
    private String name;

    @TableField("sex")
    private int sex;

    @TableField("age")
    private String age;
}
