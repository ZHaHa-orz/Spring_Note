package com.atguigu.ioc_04;

public class JavaBean {
    /**
     * 必须是public 必须是void返值必须是无参数的!
     * 命名随意!
     * 初始化方法 -> 初始化业务逻辑
     */
    public void init(){
        System.out.println("JavaBean init");
    }

    /**
     * 销毁方法
     */
    public void clear(){
        System.out.println("JavaBean Clear");
    }

}
