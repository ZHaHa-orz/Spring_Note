package com.atguigu.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// @Component
// @Aspect
public class TxAroundAdvice {
    /**
     * 环绕通知，围绕着目标方法执行
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("com.atguigu.pointcut.MyPointCut.pointCut()")
    public Object transaction(ProceedingJoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        Object result = null;
        try {
            // 增强代码 -> before
            System.out.println("开启事务");

            // 目标方法执行
            result = joinPoint.proceed(args);

            // afterReturning
            System.out.println("事务提交");
        } catch (Throwable e) {
            // afterThrowing
            System.out.println("事务回滚");
            throw new RuntimeException(e);
        }finally {
            // after
            System.out.println("事务结束");
        }
        return result;
    }
}
