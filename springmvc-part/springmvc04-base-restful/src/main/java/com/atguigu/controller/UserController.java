package com.atguigu.controller;

import com.atguigu.pojo.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @GetMapping
    public List<User> page(@RequestParam(required = false,defaultValue = "1") int page,
                           @RequestParam(required = false,defaultValue = "5") int size){
        System.out.println("page = " + page + ", size = " + size);
        return null;
    }

    @PostMapping
    public User addUser(@RequestBody User user){
        System.out.println("user = " + user);
        return user;
    }

    @GetMapping("{id}")
    public User getUser(@PathVariable Integer id){
        return null;
    }

    @PutMapping("{id}")
    public User updateUser(@PathVariable Integer id,@RequestBody User user){
        System.out.println("id = " + id + ", user = " + user);
        return user;
    }

    @DeleteMapping("{id}")
    public String deleteUser(@PathVariable Integer id){
        System.out.println("id = " + id);
        return "success";
    }

    @GetMapping("search")
    public List<User> searchUser(String keywork,
                @RequestParam(required = false) String name,
                @RequestParam(required = false) Integer age){
        return null;
    }
}
