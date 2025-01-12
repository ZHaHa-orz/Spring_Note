package com.atguigu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TopService {
    // 调用 StudentService 的 changeAge() 和 changeName() 方法
    @Autowired
    private StudentService studentService;

    @Transactional
    public void  topService(){
        studentService.changeAge();
        studentService.changeName();
    }

    @Transactional
    public void  topService2(){
        studentService.changeAge2();
        studentService.changeName2();
    }
}
