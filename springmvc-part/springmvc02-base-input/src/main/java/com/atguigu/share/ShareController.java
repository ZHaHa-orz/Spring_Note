package com.atguigu.share;

import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("share")
@ResponseBody
public class ShareController {
    @Autowired
    private ServletContext servletContext;
    public String data() {
        servletContext.setAttribute("name", "zhangsan");
        return "success";
    }

    // springmvc提供的方法: model modelMap map modelAndView
    public void data1(Model model){
        model.addAttribute("key", "value");
    }
    public void data1(ModelMap model){
        model.addAttribute("key", "value");
    }
    public void data1(Map map){
        map.put("key", "value");
    }
    public ModelAndView data1(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("key", "value");
        modelAndView.setViewName("试图名 页面名称");
        return modelAndView;
    }

}
