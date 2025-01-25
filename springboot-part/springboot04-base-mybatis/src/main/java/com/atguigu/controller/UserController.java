package com.atguigu.controller;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    // @Autowired
    // private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> queryAll(){
        return userService.queryAll();
    }

    @PostMapping
    public String insert(@RequestBody User user){
        int result = userService.insert(user);
        if (result > 0) {
            return "User added successfully";
        } else {
            return "Failed to add user";
        }
    }
}
