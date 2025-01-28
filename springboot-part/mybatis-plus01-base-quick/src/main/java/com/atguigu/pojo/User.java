package com.atguigu.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

@Data
// @TableName("t_user")
public class User {
    // @TableId(type= IdType.AUTO)
    private Long id;
    @TableField(value = "name", exist = true)
    private String name;
    private Integer age;
    private String email;

    // 当前属性对应的列就是逻辑删除的状态字段
    // 当你删除数据的时候，自动变成修改此列的属性值 默认 θ:未删除 | 1:删除
    @TableLogic
    private Integer deleted;
    @Version
    private Integer version;
}