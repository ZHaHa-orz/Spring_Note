package com.atguigu.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringIoCInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    //指定root容器对应的配置类
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{
                DataSourceJavaConfig.class,
                ServiceJavaConfig.class,
                MapperJavaConfigNew.class,
        };
    }

    //指定web容器对应的配置类
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebMvcJavaConfig.class};
    }

    //指定dispatcherServlet处理路径，通常为 /
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
