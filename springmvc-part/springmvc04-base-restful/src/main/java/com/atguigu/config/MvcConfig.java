package com.atguigu.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@ComponentScan("com.atguigu.controller")
@EnableWebMvc
public class MvcConfig {
}
