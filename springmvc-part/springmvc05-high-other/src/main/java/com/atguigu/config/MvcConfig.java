package com.atguigu.config;

import com.atguigu.interceptor.MyInterceptor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
@ComponentScan({"com.atguigu.controller","com.atguigu.error"})
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 配置方案1: 拦截全部请求
        // registry.addInterceptor(new MyInterceptor()); // 拦截器

        // 配置方案2: 拦截部分请求 /user/data
        // * 任意一层字符串 /user/*
        // ** 任意多层字符串 /user/**
        // registry.addInterceptor(new MyInterceptor())
        //         .addPathPatterns("/user/*");

        // 配置方案3: 排除部分请求 /user/data1 
        // 排除的地址应该在拦截地址内部
        // registry.addInterceptor(new MyInterceptor())
        //         .addPathPatterns("/user/**")
        //         .excludePathPatterns("/user/data1");
    }
}
