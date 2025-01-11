package com.atguigu.ioc_03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import jakarta.annotation.Resource;
@Controller
public class UserController {
    // <property userService -> 对应类型的bean装配
    // 自动装配注解（DI） : 1.ioc容器中查找符合类型的bean，2.注入到属性中
    // @Autowired 在成员变量上直接标记 不需要提供set方法
    @Autowired
    // 当有多个相同类型的bean时，通过名称装配 或直接定义实现类名 private UserService newUserServiceImpl;
    @Qualifier("userServiceImpl")
    // @Autowired + @Qualifier(value = "test") == @Resource(name = "test")
    private UserService userService;

    public void show() {
        // 业务逻辑
        String result = userService.show();
        System.out.println("result = " + result);
    }

    @Resource(name="newUserServiceImpl")
    private UserService userServiceTest;

    // 如果导入的是 javax.annotation.Resource 会报空指针异常，需要进行构造器注入
    // public UserController(@Qualifier("newUserServiceImpl") UserService userServiceTest) {
    //     this.userServiceTest = userServiceTest;
    // }

    public void show1() {
        // 业务逻辑
        String result = userServiceTest.show();
        System.out.println("result = " + result);
    }
}
