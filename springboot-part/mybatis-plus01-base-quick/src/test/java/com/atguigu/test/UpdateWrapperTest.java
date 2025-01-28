package com.atguigu.test;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UpdateWrapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01() {
        // 将年龄大于20并且用户名中包含有a或邮箱为null的用户信息修改

        // QueryWrapper修改 【条件】
        // 1.准备要修改的实体类数据
        // 2.不能改为null
        // QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // queryWrapper.gt("age", 20)
        //         .like("name", "a")
        //         .or().isNull("email");
        //
        // User user = new User();
        // user.setAge(18);
        // user.setEmail("123@qq.com");

        // UpdateWrapper修改【条件，修改】
        // 1.直接携带修改数据 set("列名”,“值”)
        // 2.指定任意修改值 set("列明”,null)

        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.gt("age", 20)
                .like("name", "a")
                .or().isNull("email")
                .set("age", 99)
                .set("email", null);
        userMapper.update(updateWrapper);
    }
}
