package com.atguigu.ioc_04;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JavaBean {
    /**
     * <bean id class
     *      <property name="name" value=""/>
     */
    // 方案1：直接赋值
    // 方案2：注解赋值 @Value注解 直接赋值 读取外部配置
    //       默认值语法 @Value(${key:value默认值})
    private String name="张三";

    @Value("19")
    private int age;

    @Value("${jdbc.username:admin}")    // 如果配置文件中没有配置，则使用默认值admin
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Override
    public String toString() {
        return "JavaBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
