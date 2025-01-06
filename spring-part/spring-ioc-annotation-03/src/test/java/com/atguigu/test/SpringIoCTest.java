package com.atguigu.test;

import com.atguigu.ioc_1.XxxController;
import com.atguigu.ioc_1.XxxDao;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIoCTest {
    @Test
    public void testIoc_01(){
        // 1. 创建ioc容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-01.xml");
        // 2. 获取组件
        XxxDao bean = applicationContext.getBean(XxxDao.class);
        System.out.println("bean = " + bean);

        // 添加ioc注解,默认的组件名为类的首字母小写
        Object xxxService = applicationContext.getBean("xxxService");
        System.out.println("xxxService = " + xxxService);

        // 3. 关闭ioc容器
        applicationContext.close();

    }
}
