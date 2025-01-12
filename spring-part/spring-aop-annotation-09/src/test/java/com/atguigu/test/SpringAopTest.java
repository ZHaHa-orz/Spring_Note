package com.atguigu.test;

import com.atguigu.config.JavaConfig;
import com.atguigu.service.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(value= JavaConfig.class)
public class SpringAopTest {
    // aop 默认使用jdk动态代理生成代理对象，所以需要实现接口，使用接口接值
    @Autowired
    private Calculator calculator;

    @Test
    public void test() {
        calculator.add(1, 2);
        // System.out.println("------------------");
        // calculator.sub(1, 2);
        // System.out.println("------------------");
        // calculator.mul(1, 2);
        // System.out.println("------------------");
        // // calculator.div(1, 0);
        // calculator.div(1, 2);
    }
}
