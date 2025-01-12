package com.atguigu.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1) //设置优先级，数字越小，优先级越高 默认是Integer的最大值
public class TxAdvice {
    @Before("com.atguigu.pointcut.MyPointCut.pointCut()")
    public void begin(){
        System.out.println("开启事务");
    }
    @AfterReturning(value = "com.atguigu.pointcut.MyPointCut.pointCut()", returning = "result")
    public void commit(Object result){
        System.out.println("提交事务");
    }
    @AfterThrowing(value = "com.atguigu.pointcut.MyPointCut.pointCut()",throwing = "t")
    public void rollback(JoinPoint joinPoint, Throwable t){
        System.out.println("回滚事务");
    }
}
