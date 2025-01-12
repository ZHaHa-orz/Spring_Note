package com.atguigu.statics;

import com.atguigu.Calculator;

public class StaticProxyCalculator implements Calculator {

    private Calculator calculator;
    // 使用构造函数传入目标（房东）
    public StaticProxyCalculator(Calculator target) {
        this.calculator = target;
    }

    @Override
    public int add(int i, int j) {
        System.out.println("i = " + i + ", j = " + j);
        int add = calculator.add(i, j);
        System.out.println("add = " + add);
        return add;
    }

    @Override
    public int sub(int i, int j) {
        return 0;
    }

    @Override
    public int mul(int i, int j) {
        return 0;
    }

    @Override
    public int div(int i, int j) {
        return 0;
    }
}
