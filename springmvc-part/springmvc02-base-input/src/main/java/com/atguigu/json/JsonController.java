package com.atguigu.json;

import com.atguigu.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("json")
@Controller
@ResponseBody
public class JsonController {
    @PostMapping("data")
    public String data(@RequestBody Person person) {
        // data -> 请求体post {name,age,gender}
        // 使用postman测试工具    注意用post方法
        // 前端 -> json -> 415 不支持数据类型
        // 原因: Java原生的api,只支持路径参数和param参数 request.getParameter("key");  不支持json
        //      json就是前端的格式
        // 解决: 1.导入json处理的依赖    2.handlerAdapter配置json转化器
        System.out.println("person = " + person);
        // 在这里可以使用 person 对象来操作 JSON 数据中包含的属性
        return person.toString();
    }
}
