package com.gong_redis.controller;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author:
 * @Project: JavaLaity
 * @Pcakage: com.gong_redis.controller.UserVo
 * @Date: 2022年10月05日 11:21
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {
    @TableField("id")
    private int id;
    @TableField("name")
    private String name;
    @TableField("sex")
    private int sex;
    @TableField("age")
    private String age;
}
