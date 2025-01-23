package com.atguigu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * 1. controller
 * 2. 全局异常处理器
 * 3. handlerMapper handlerAdapter
 * 4. 静态资源处理
 * 5. jsp 视图解析器前后缀
 * 6. json 转化器
 * 7. 拦截器
 */
@Configuration
@ComponentScan({"com.atguigu.controller", "com.atguigu.error"})
@EnableWebMvc
public class WebMvcJavaConfig implements WebMvcConfigurer {
    // 静态资源处理
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/views/", ".jsp");
    }

    public void addInterceptors(InterceptorRegistry registry) {
        // registry.addInterceptor()
    }
}
