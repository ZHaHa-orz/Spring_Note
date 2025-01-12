package com.atguigu.advice;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 增强类的内部要存储增强代码
 *  1. 定义方法存储增强代码
 *      具体定义几个方法，根据插入的位置决定
 *  2. 使用注解配置 指定插入目标方法的位置
 *      前置 @Before
 *      后置 @After
 *      异常 @AfterThrowing
 *      返回 @AfterReturning
 *      环绕 @Around
 *
 *      try{
 *          前置
 *          调用目标方法
 *          后置
 *      }catch{
 *          异常
 *      }finally{
 *          返回
 *      }
 *
 *  3. 配置切点表达式 [ 选中插入的方法 切点 ]
 *
 *  4. 补全注解
 *      加入ioc容器 @Component
 *      切面类 @Aspect = 切点+增强
 */
@Component
@Aspect
@Order(10)
public class LogAdvice {
    /**
     * TODO: 切点表达式
     *  语法：execution(1访问权限 2返回值类型 3包名.4类名.5方法名(6参数))
     *      1. 访问权限
     *          public | private
     *      2. 方法的返回参数类型
     *          String | int | void
     *      如果不考虑访问修饰符和返回值!这两位整合成一起写 *
     *      如果要是不考虑,必须两个都不考虑！ 不能出现 * String
     *      3. 包名.类名
     *          具体包：com.atguigu.service.impl
     *          单层模糊：com.atguigu.service.*
     *          多层模糊：com..impl
     *          ..不能开头  可以写成 *..impl
     *      4. 类名
     *          具体：UserServiceImpl
     *          模糊：*
     *          部分模糊：*Impl
     *      5. 方法名 与类名一致
     *      6. 形参数列表
     *          没有参数：()
     *          具体参数：(String),(int,String)
     *          模糊参数：(..) 有没有参数都行
     *          部分模糊：(String..) String开头
     *                  (..int) int结尾
     *                  (String..int) 中间有没有参数都行
     */
    /**
     * TODO：切点表达式的重用
     *  1. 定义方法
     *      方法的返回值是 void
     *      注解 @Pointcut
     *      增强注解中引用切点表达式的方法
     *  2. 创建一个存储切点的类
     *      单独维护切点表达式
     *      其他类的切点方法 类的全限定符号.方法名()
     */

    @Before("com.atguigu.pointcut.MyPointCut.pointCut()")
    public void start(){
        System.out.println("前置通知-方法开始了");
    }
    @After("com.atguigu.pointcut.MyPointCut.pointCut()")
    public void after(){
        System.out.println("后置通知-方法结束了");
    }
    @AfterThrowing("com.atguigu.pointcut.MyPointCut.pointCut()")
    public void error() throws Exception{
        // System.out.println("异常通知-方法报错了");
        // 输出异常
        Exception e = new Exception("异常通知-方法报错了");
        System.out.println(e.getMessage());
        throw e;
    }

    @AfterReturning("com.atguigu.pointcut.MyPointCut.pointCut()")
    public void afterReturning(){
        System.out.println("返回通知-fianally");
    }
}
