package com.atguigu;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import org.springframework.web.WebApplicationInitializer;

public class Main implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // 每当web应用启动时,都会执行onStartup方法
        System.out.println("web应用启动了...");
        // ioc容器的初始化
        // dispatcherServlet的初始化
    }
}
