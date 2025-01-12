package com.atguigu;

import com.atguigu.dyn.ProxyFactory;
import com.atguigu.statics.StaticProxyCalculator;

public class UseAop {
    public static void main(String[] args) {
        // 房东
        Calculator target = new CalculatorPureImpl();
        // 中介
        Calculator proxy = new StaticProxyCalculator(target);
        // 调用
        int result = proxy.add(1, 2);
        System.out.println("result = " + result);
        System.out.println("=====================");
        // jdk 代理
        ProxyFactory proxyFactory = new ProxyFactory(target);
        // 使用接口接值
        Calculator proxy1 = (Calculator) proxyFactory.getProxy();
        int result1 = proxy1.add(1, 2);
        System.out.println("result1 = " + result1);
    }
}
