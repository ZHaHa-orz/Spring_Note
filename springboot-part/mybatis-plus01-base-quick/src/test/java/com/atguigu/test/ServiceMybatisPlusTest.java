package com.atguigu.test;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ServiceMybatisPlusTest {
    @Autowired
    private UserService userService;

    @Test
    public void test_save(){
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            User user = new User();
            user.setName("user" + i);
            user.setAge(10+i);
            user.setEmail("user" + i + "@atguigu.com");
            list.add(user);
        }

        boolean b = userService.saveBatch(list);
        System.out.println("b = " + b);
    }

    @Test
    public void test_saveOrUpdate(){
        // 如果 id 为 null, 插入
        // 如果 id 不为 null, 更新
        User user = new User();
        user.setId(6L);
        user.setName("user0");
        user.setAge(1);
        user.setEmail("user0@atguigu.com");
        userService.saveOrUpdate(user);
    }

    @Test
    public void test_remove(){
        boolean b = userService.removeById(1884102368635760642L);
        System.out.println("b = " + b);
    }

    @Test
    public void test_update(){
        User user = new User();
        user.setId(6L);
        user.setName("user_update");
        user.setAge(1);
        user.setEmail("user0@atguigu.com");
        userService.updateById(user);
    }

    @Test
    public void test_getOrList(){
        User byId = userService.getById(1L);    // 返回的是单个对象
        System.out.println("byId = " + byId);

        List<User> list = userService.list((Wrapper<User>) null);   // 根据条件 (null) 返回的集合
        System.out.println("list = " + list);
    }
}
