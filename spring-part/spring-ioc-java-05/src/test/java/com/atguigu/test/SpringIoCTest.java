package com.atguigu.test;

import com.atguigu.config.JavaConfiguration;
import com.atguigu.config.JavaConfigurationA;
import com.atguigu.ioc_01.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringIoCTest {
    @Test
    public void test_01() {
        // 1.创建ioc
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(JavaConfiguration.class);
        // 或
        AnnotationConfigApplicationContext applicationContext1 =
                new AnnotationConfigApplicationContext();
        applicationContext1.register(JavaConfiguration.class);
        applicationContext1.refresh();
        // 2.获取Bean
        StudentController bean = applicationContext.getBean(StudentController.class);
        System.out.println("bean = " + bean);
    }

    @Test
    public void test_02(){
        // 整合配置类
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(JavaConfigurationA.class);
    }
}
