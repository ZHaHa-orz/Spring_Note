package com.atguigu.test;

import com.atguigu.config.JavaConfig;
import com.atguigu.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ControllerTest {
    @Test
    public  void testRun(){
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(JavaConfig.class);
        StudentController controller = applicationContext.getBean(StudentController.class);
        controller.findAll();
    }
}