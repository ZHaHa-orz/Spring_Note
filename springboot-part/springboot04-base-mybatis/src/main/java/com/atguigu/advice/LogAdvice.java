package com.atguigu.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(5)
public class LogAdvice {
    @Before("execution(* com..service.*.*(..))")
    public void before(JoinPoint joinPoint){
        String simpleName = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        System.out.println(simpleName+"::"+methodName+" 开始执行");
    }
}
