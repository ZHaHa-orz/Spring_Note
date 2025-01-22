package com.atguigu.json;

import com.atguigu.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("json")
@RestController // == +@ResponseBody + @Controller
public class JsonController {
    @GetMapping("data")
    public User data(){
        User user = new User();
        user.setName("zhangsan");
        user.setAge(18);
        return user;    // user -> handlerAdapter -> json -> @ResponseBody -> json直接返回 [前后端分离模式]
    }

    @GetMapping("data1")
    public List<User> data1(){
        User user = new User();
        user.setName("zhangsan");
        user.setAge(18);
        List<User> users = new ArrayList<>();
        users.add(user);
        return users;
    }
}
