package com.atguigu.requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    //handler -> handlerMapping 指定访问地址

    /**
     * @WebServlet(必须斜杆开头)
     * @RequestMapping(不必须斜杆开头)
     *  1. 精准地址 [一个 | 多个]  /user/login {"地址1","地址2"}
     *  2. 模糊地址 [*: 一个 | **: 多个]
     *      /user/*: -> /user/a 可以 | /user/a/a 不行
     *      /user/**: -> /user/a 可以 | /user/a/a 可以
     *  3. 类上和 方法上添加@RequestMapping的区别
     *      类: 提取通用的访问地址
     *      方法: 具体的handler地址
     *      访问: 类地址 + 方法地址
     *  4. 请求方式指定
     *      客户端 -> http (get | post | put | delete) -> dispatcherServlet -> handler
     *      默认情况: @RequestMapping(method = RequestMethod.GET) -> get请求
     *          RequestMethod.POST -> post请求    {RequestMethod.PUT,RequestMethod.DELETE} -> put | delete 请求
     *      不符合请求方式: 出现405异常
     *  5. 注解进阶
     *      GetMapping  PostMapping  PutMapping  DeleteMapping
     *      get @GetMapping == @RequestMapping(method = RequestMethod.GET)
     */
    // @RequestMapping // /user
    @GetMapping
    public String index(){
        return null;
    }

    // @RequestMapping("login")
    @GetMapping("login")
    public String login(){
        return null;
    }

    // @RequestMapping("register")
    @PostMapping("register")
    public String register(){
        return null;
    }

}
