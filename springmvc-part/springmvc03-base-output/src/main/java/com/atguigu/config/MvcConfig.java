package com.atguigu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
@ComponentScan("com.atguigu.json")
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {
    // handlerMapping 和 handlerAdapter 配置json 转化器
    // 视图解析器, 指定前后端
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        // registry 可以快速添加前后缀
        registry.jsp("/WEB-INF/views/", ".jsp");
        // handler -> index
    }

    // 开启静态资源查找 <mvc:default-servlet-handler/>
    // dispatcherServlet -> handlerMapping找有没有对应的handler -> [没有 -> 找有没有静态资源]
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
