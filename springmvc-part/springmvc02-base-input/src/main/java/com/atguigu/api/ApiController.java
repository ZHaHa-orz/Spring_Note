package com.atguigu.api;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ApiController {

    @Autowired
    private ServletContext context; // ioc容器获取对应类型实体对象(组件) 并 自动装配
    public void data(HttpServletResponse response,
                       HttpServletRequest request,
                       HttpSession session) {
        // ServletContext [1.最大的配置文件 2.全局最大共享域 3.核心api getRealPath]
        // 获取：方案1： request获取 session获取
        ServletContext context = request.getServletContext();
        ServletContext context1 = session.getServletContext();

        // 方案2：ServletContext 会自动装入到ioc容器
        // 直接全局注入
    }
}
