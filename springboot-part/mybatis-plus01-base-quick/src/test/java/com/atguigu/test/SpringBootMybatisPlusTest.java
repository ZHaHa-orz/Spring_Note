package com.atguigu.test;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class SpringBootMybatisPlusTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){
        List<User> users = userMapper.selectList(null);

        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void test_insert(){
        User user = new User();
        user.setName("张三");
        user.setAge(18);
        user.setEmail("zhangsan@atguigu.com");
        int row = userMapper.insert(user);
        System.out.println("row = " + row);
    }

    @Test
    public void test_delete(){
        // 根据主键删除
        int row = userMapper.deleteById(1212203009);
        System.out.println("row = " + row);

        // 根据age删除
        Map param = new HashMap();
        param.put("age", 20);
        int row1 = userMapper.deleteByMap(param);
        System.out.println("row1 = " + row1);

        // wrapper 条件封装对象，无限的封装条件
        // userMapper.delete(wrapper)
    }

    @Test
    public void test_update(){
        // TODO：update 当属性为null的时候,不修改, 这就是为什么属性要设置包装类型 Integer 而不设置成基础类型 int 的原因

        // updateById 实体类id必须有值
        // user id = 1 的 age 改为 30
        User user = new User();
        user.setId(1L);
        user.setAge(30);
        // update user set age=30 where id=1
        int row = userMapper.updateById(user);
        System.out.println("row = " + row);

        // update 实体类可以没有id值
        // 将所有人的年龄改为22
        User user1 = new User();
        user1.setAge(22);
        int row1 = userMapper.update(user1, null);// null 表示没有条件
        System.out.println("row1 = " + row1);
    }

    @Test
    public void test_select(){
        // 根据id查询 id = 1
        User user = userMapper.selectById(1);
        System.out.println("user = " + user);
        System.out.println("---------------------------------------");
        // ids集合查询
        List<Long> ids = new ArrayList<>();
        ids.add(1L); ids.add(3L);
        List<User> users = userMapper.selectBatchIds(ids);
        for (User user1 : users) {
            System.out.println("user1 = " + user1);
        }
    }
}
