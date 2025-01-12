package com.atguigu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan({"com.atguigu.service", "com.atguigu.advice", "com.atguigu.pointcut"})
@EnableAspectJAutoProxy // 开启aop
public class JavaConfig {
}
