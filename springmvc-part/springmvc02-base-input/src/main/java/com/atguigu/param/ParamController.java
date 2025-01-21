package com.atguigu.param;

import com.atguigu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("param")
public class ParamController {
    // 直接接收
    // /param/data?username=root&password=123456
    @RequestMapping("data")
    @ResponseBody
    public String data(String username,int password) {
        if(username==null){
            return "error";
        }
        System.out.println("name = " + username + ", password = " + password);
        return "name = " + username + ", password = " + password;
    }

    // 注解指定
    // /param/data2?account=root&page=1
    // account指定了参数名，必须传递  page可以不必须传递，默认值是1
    // @RequestParam    ->  形参列表: 指定请求参数名 | 是否必须传递 | 非必需传递设置默认值
    //      用法: @RequestParam(value="参数名",
    //                         required = false 前端是否必须传递此参数, 默认是true, 不传会报400异常,
    //                         defaultValue = "默认值"    字符串, 当非必须传递时, 如果不传递, 则使用默认值
    //                         )
    @GetMapping("data1")
    @ResponseBody
    public String data1(@RequestParam(value = "account") String username,
                        @RequestParam(required = false, defaultValue = "1") int page){
        System.out.println("name = " + username + ", page = " + page);
        return "name = " + username + ", page = " + page;
    }

    // 特殊值
    // /param/data2?hbs=吃&hbs=喝&hbs=玩
    // hbs可以传递多个值，多个值用逗号隔开，接收到参数是一个List<String> 需要加@RequestParam注解
    @GetMapping("data2")
    @ResponseBody
    public String data2(@RequestParam List<String> hbs){
        System.out.println("hbs = " + hbs);
        return "success";
    }

    // 实体类接值    用户注册 -> 对应的实体类 -> 插入到数据库
    // param/data3?name=root&age=18
    @RequestMapping("data3")
    @ResponseBody
    public String data3(User user){
        System.out.println("user = " + user);
        return user.toString();
    }

}
