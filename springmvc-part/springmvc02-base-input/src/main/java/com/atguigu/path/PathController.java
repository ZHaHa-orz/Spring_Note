package com.atguigu.path;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("path")
@ResponseBody
public class PathController {
    // path/账号/密码
    // 动态路径设计   {key} = *   {key} 在形参列表获取传入的参数
    // @PathVariable 获取路径中的参数
    @RequestMapping("/{account}/{password}")
    public String login(@PathVariable String account, @PathVariable String password) {
        String s = "account = " + account + ", password = " + password;
        System.out.println(s);
        return s;
    }
}
