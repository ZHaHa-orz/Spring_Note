package com.atguigu.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {

    // if( ! preHandler()){return;}
    // 在处理请求的目标 handler 方法前执行
    // 执行handler之前! 调用的拦截方法!
    // 编码格式设置 | 登录保护 | 权限处理
    /**
     * filter - doFiler
     * @param request 请求对象
     * @param response 响应对象
     * @param handler 处理请求的目标
     * @return true：放行 | false：不放行
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("request = " + request + ", response = " + response + ", handler = " + handler);
        System.out.println("MyInterceptor.preHandle");
        return true;
    }
 
    // 在目标 handler 方法之后，handler报错不执行!

    /**
     * 当handler执行完毕后, 触发的方法 没有拦截机制
     * @param request
     * @param response
     * @param handler
     * @param modelAndView 返回的视图和共享域数据对象
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("request = " + request + ", response = " + response + ", handler = " + handler + ", modelAndView = " + modelAndView);
        System.out.println("MyInterceptor.postHandle");
    }
 
    /**
     * 渲染视图之后执行(最后),一定执行!
     * 整体处理完毕
     * @param request
     * @param response
     * @param handler
     * @param ex handler报错了 异常对象
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("request = " + request + ", response = " + response + ", handler = " + handler + ", ex = " + ex);
        System.out.println("MyInterceptor.afterCompletion");
    }
}