package com.atguigu.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;

/**
 * 定义四个增强方法,获取目标方法的信息 返回值 异常对象
 *
 * TODO：增强方法中获取目标方法信息
 *      1. 全部增强方法中，都可以获取目标方法信息（方法名，参数，访问修饰符……）
 *          (JoinPoint joinPoint) 包含了目标方法信息
 *      2. 返回的结果 - @AfterReturning
 *          (Object result) result 接受返回结果
 *          在 @AfterReturning(value = "execution()" (returning = "形参名"))
 *      3. 异常的信息 - @AfterThrowing
 *          (Throwable throwable) throwable 接收异常对象
 *          在 @AfterThrowing(value = "execution()" (throwing = "形参名"))
 */
// @Component
// @Aspect
public class MyAdvice {
    @Before("com.atguigu.pointcut.MyPointCut.myPointCut()")
    public void before(JoinPoint joinPoint){
        // System.out.println("前置增强");
        // 1. 获取目标方法属于的类的信息
        String simpleName = joinPoint.getTarget().getClass().getSimpleName();
        // 2. 获取目标方法名
        String name = joinPoint.getSignature().getName();
        // 3. 获取目标方法的参数
        Object[] args = joinPoint.getArgs();
        // 4. 获取目标方法的访问修饰符
        int modifiers = joinPoint.getSignature().getModifiers();
        String s = Modifier.toString(modifiers);
    }

    @After("com.atguigu.pointcut.MyPointCut.myPointCut()")
    public void after(JoinPoint joinPoint){
        // System.out.println("后置增强");
    }

    @AfterThrowing(value = "com.atguigu.pointcut.MyPointCut.myPointCut()",throwing = "throwable")
    public void afterThrowing(JoinPoint joinPoint,Throwable throwable){
        // System.out.println("异常增强");
    }

    @AfterReturning(value ="com.atguigu.pointcut.MyPointCut.myPointCut()",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
        // System.out.println("返回增强");
    }
}
