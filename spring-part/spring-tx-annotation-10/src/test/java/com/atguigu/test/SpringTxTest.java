package com.atguigu.test;

import com.atguigu.config.JavaConfig;
import com.atguigu.service.StudentService;
import com.atguigu.service.TopService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.io.FileNotFoundException;

/**
 * projectName: com.atguigu.test
 *
 * description:
 */
@SpringJUnitConfig(JavaConfig.class)
public class SpringTxTest {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TopService topService;

    @Test
    public void  testTx_01(){
        studentService.changeInfo1();
    }

    @Test
    public void  testTx_02(){
        studentService.changeInfo2();
    }

    @Test
    public void  testTx_03(){
        studentService.changeInfo3();
    }

    @Test
    public void  testTx_04() throws FileNotFoundException {
        studentService.changeInfo4();
    }

    @Test
    public void  testTx_05(){
        studentService.changeInfo5();
    }

    @Test
    public void  testTx_06(){
        topService.topService();
    }

    @Test
    public void  testTx_07(){
        topService.topService2();
    }
}
