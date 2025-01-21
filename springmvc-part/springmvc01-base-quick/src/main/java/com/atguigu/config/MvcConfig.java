package com.atguigu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

// TODO: SpringMVC对应组件的配置类 [声明SpringMVC需要的组件信息]
// TODO: 导入handlerMapping和handlerAdapter的三种方式
//   1.自动导入handlerMapping和handlerAdapter [推荐]
//   2.可以不添加,springmvc会检查是否配置handlerMapping和handlerAdapter,没有配置默认加载
//   3.使用@Bean方式配置handlerMapper和handlerAdapter

// 1.controller 配置ioc容器
// 2.handlerMapping handlerAdapter 加入到ioc容器
@Configuration
@ComponentScan("com.atguigu.controller")
public class MvcConfig {
    @Bean
    public RequestMappingHandlerMapping handlerMapping(){
        return new RequestMappingHandlerMapping();
    }

    @Bean
    public RequestMappingHandlerAdapter handlerAdapter(){
        return new RequestMappingHandlerAdapter();
    }
}
