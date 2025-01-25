package com.atguigu.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 读取配置的方式1: @Value直接可以在属性上添加
 *      @ Value(key必须写全了)
 *      @ value只能读取单个值
 * 批量配置读取:
 *      @ConfigurationProperties(prefix = "zwf") 通用的前提
 *      实体类
 *          属性名 = 最后一个key的值
 *      优势1: 方便 不用一个一个读取
 *      优势2: 可以给集合类型赋值
 */
@Data
@Component
@ConfigurationProperties(prefix = "zwf.info")
public class User {
    // @Value("${zwf.info.name}")
    private String name;

    // @Value("${zwf.info.age}")
    private Integer age;

    // @Value("${zwf.info.skill}")
    private List<String> skill;
}
