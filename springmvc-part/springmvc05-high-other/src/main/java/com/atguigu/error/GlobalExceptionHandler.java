package com.atguigu.error;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 全局异常发生,会走此类写的handler
// @ControllerAdvice   // 可以返回逻辑视图 转发和重定向的
@RestControllerAdvice   // == @ControllerAdvice + @ResponseBody 直接返回json字符串
public class GlobalExceptionHandler {
    // 发生异常 -> controllerAdvice 注解的类型 -> @ExceptionHandler(指定的异常类) -> handler
    @ExceptionHandler(ArithmeticException.class)
    public Object ArithmeticExceptionHandler(ArithmeticException e) {
        // 自定义处理异常 handler
        String message = e.getMessage();
        System.out.println("message = " + message);
        return message;
    }

    @ExceptionHandler(Exception.class)
    public Object ExceptionHandler(Exception e) {
        String message = e.getMessage();
        System.out.println("message = " + message);
        return message;
    }

}
