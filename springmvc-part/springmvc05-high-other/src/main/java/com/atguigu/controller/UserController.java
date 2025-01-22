package com.atguigu.controller;

import com.atguigu.pojo.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

@RestController
@RequestMapping("user")
public class UserController {
    // 接收用户数据, 用户有校验注解
    /**
     * 实体类属性添加校验注解
     * handler(@Validated 实体类 对象)
     * param | json 校验注解都有效果
     * json参数要加 @RequestBody
     * 如果不符合校验规则, 自定义返回结果 -> {code:404}等 -> 前端
     * 捕捉错误绑定错误信息:
     *      1. handler(校验对象, BindingResult result) 要求: bindingResult 必须紧挨着校验对象
     *      2. result.getFieldError().getDefaultMessage() 获取错误信息
     */
    @PostMapping("register")
    public Object register(@Validated @RequestBody User user, BindingResult result){
        if(result.hasErrors()){
            Map data = new HashMap();
            data.put("code", 400);
            Map msg = new HashMap();
            if(user.getName().isBlank()){
                msg.put("msg1", "用户名不能为空");
            }
            if(user.getPassword().length() < 6){
                msg.put("msg2", "密码必须大于6位");
            }
            if(user.getAge() < 1){
                msg.put("msg2", "用户年龄不能小于1");
            }
            // and so on
            data.put("msg", msg);
            return data;
        }

        System.out.println("user = " + user);

        return user;
    }

    @GetMapping("data")
    public String data() {
        String name=null;
        name.toString(); // 空指针异常
        return "ok";
    }

    @GetMapping("data1")
    public String data1() {
        int i=1/0; // 运行时异常 - 除零异常
        return "ok";
    }
}
