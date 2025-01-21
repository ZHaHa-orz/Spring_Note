package com.atguigu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc   // handlerAdapter配置了json转化器
                // 底层配置了handlerMapping和handlerAdapter
@Configuration
@ComponentScan("com.atguigu.header")
public class MvcConfig {
    // @Bean
    // public RequestMappingHandlerMapping handlerMapping() {
    //     return new RequestMappingHandlerMapping();
    // }
    // @Bean
    // public RequestMappingHandlerAdapter handlerAdapter() {
    //     return new RequestMappingHandlerAdapter();
    // }
}
