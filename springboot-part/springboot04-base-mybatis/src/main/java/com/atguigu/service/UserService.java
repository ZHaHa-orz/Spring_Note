package com.atguigu.service;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> queryAll(){
        return userMapper.queryAll();
    }

    @Transactional
    public int insert(User user){
        int row = userMapper.insert(user);
        System.out.println("row = " + row);
        // int i = 1/0;
        return row;
    }
}
