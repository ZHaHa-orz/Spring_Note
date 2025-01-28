package com.atguigu.test;

import com.atguigu.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TableLogicTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {
        userMapper.selectList(null).forEach(System.out::println);
        System.out.println("----------------------------------------");
        userMapper.deleteById(1L);
        userMapper.selectList(null).forEach(System.out::println);
    }
}
