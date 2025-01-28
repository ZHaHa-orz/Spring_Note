package com.atguigu.test;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class LambdaWrapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01() {
        // 查询用户名包含 a like，年龄在20到30之间，并且邮箱不为null的用户信息
        // QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // queryWrapper.like("name", "a")
        //         .between("age", 20, 30)
        //         .isNotNull("email");

        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(User::getName, "a")
                .between(User::getAge, 20, 30)
                .isNotNull(User::getEmail);

        // select * from user where name like '%a%' and age >= 20 and age <= 30 and email is not null
        List<User> list = userMapper.selectList(lambdaQueryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test02() {
        // 查询用户名包含 a like，年龄在20到30之间，并且邮箱不为null的用户信息
        LambdaUpdateWrapper<User> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.like(User::getName, "a")
                .between(User::getAge, 20, 30)
                .isNotNull(User::getEmail)
                .set(User::getName, null)
                .set(User::getAge, 88);

        // select * from user where name like '%a%' and age >= 20 and age <= 30 and email is not null
        List<User> list = userMapper.selectList(lambdaUpdateWrapper);
        list.forEach(System.out::println);
    }
}
