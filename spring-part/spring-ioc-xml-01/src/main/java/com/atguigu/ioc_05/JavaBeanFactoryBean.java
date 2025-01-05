package com.atguigu.ioc_05;

import org.springframework.beans.factory.FactoryBean;

public class JavaBeanFactoryBean implements FactoryBean<JavaBean> {
    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public JavaBean getObject() throws Exception {
        // 使用自己的方法实例化对象
        JavaBean javaBean = new JavaBean();
        javaBean.setName(value);
        return javaBean;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        // 默认单例
        return FactoryBean.super.isSingleton();
    }
}
