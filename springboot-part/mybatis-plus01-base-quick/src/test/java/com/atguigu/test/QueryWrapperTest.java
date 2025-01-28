package com.atguigu.test;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class QueryWrapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01() {
        // 查询用户名包含 a like，年龄在20到30之间，并且邮箱不为null的用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "a");
        queryWrapper.between("age", 20, 30);
        queryWrapper.isNotNull("email");
        // 相当于 queryWrapper.like("name", "a").between("age", 20, 30).isNotNull("email");

        // select * from user where name like '%a%' and age >= 20 and age <= 30 and email is not null
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test02() {
        // 按年龄降序查询用户，如果年龄相同则按id升序排列
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age").orderByAsc("id");

        // SELECT * FROM t_user ORDER BY age DESC,id ASC
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }
    @Test
    public void test03() {
        // 删除email为空的用户
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        userMapper.delete(queryWrapper);
    }

    @Test
    public void test04() {
        // 将年龄大于20并且用户名中包含有a或邮箱为null的用户信息修改
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age", 20)
                .like("name", "a")
                .or().isNull("email");

        User user = new User();
        user.setAge(18);
        user.setEmail("123@qq.com");


        userMapper.update(user, queryWrapper);
    }

    @Test
    public void test05() {
        // 查询用户信息的name和age字段
        // SELECT name,age FROM t_user where id > 1;
        // 默认查询的是全部列
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("id", 1).select("name", "age");
        userMapper.selectList(queryWrapper);
    }

    @Test
    public void test06(){
        // 前端传入两个参数 name age
        String name = "root";
        int age = 18;

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 判断条件拼接
        // 当name不为null拼接等于, age > 1 拼接等于判断
        // 方案1: 手动判断
        // if (!StringUtils.isNotBlank(name)){
        //     queryWrapper.eq("name",name);
        // }
        // if (age != null && age > 17){
        //     queryWrapper.eq("age",age);
        // }

        //方案2: 拼接condition判断
        //每个条件拼接方法都condition参数,这是一个比较运算,为true追加当前条件!
        //eq(condition,列名,值)
        queryWrapper.eq(!StringUtils.isNotBlank(name),"name",name)
                .eq(age > 17,"age",age);
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }
}
