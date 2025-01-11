package com.atguigu.test;

import com.atguigu.ioc_01.XxxDao;
import com.atguigu.ioc_03.UserController;
import com.atguigu.ioc_04.JavaBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIoCTest {
    @Test
    public void testIoc_01(){
        // 1. 创建ioc容器
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring-01.xml");
        // 2. 获取组件
        XxxDao bean = applicationContext.getBean(XxxDao.class);
        System.out.println("bean = " + bean);

        // 添加ioc注解,默认的组件名为类的首字母小写
        Object xxxService = applicationContext.getBean("xxxService");
        System.out.println("xxxService = " + xxxService);

        // 3. 关闭ioc容器
        applicationContext.close();
    }

    @Test
    public void testIoc_02(){
        // 1. 创建ioc容器
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring-02.xml");
        // 2. 获取组件
        JavaBean bean = applicationContext.getBean(JavaBean.class);
        JavaBean bean1 = applicationContext.getBean(JavaBean.class);
        System.out.println(bean1 == bean);

        // 3. 关闭ioc容器
        applicationContext.close();
    }

    @Test
    public void testIoc_03(){
        // 1. 创建ioc容器
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring-03.xml");
        // 2. 获取组件
        UserController userController = applicationContext.getBean(UserController.class);
        userController.show();
        userController.show1();
        // 3. 关闭ioc容器
        applicationContext.close();
    }
    @Test
    public void testIoc_04(){
        // 1. 创建ioc容器
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("spring-04.xml");
        // 2. 获取组件
        JavaBean bean = applicationContext.getBean(JavaBean.class);
        System.out.println("bean = " + bean);
        // 3. 关闭ioc容器
        applicationContext.close();
    }
}
