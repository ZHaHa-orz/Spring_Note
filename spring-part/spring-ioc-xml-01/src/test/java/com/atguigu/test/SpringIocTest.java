package com.atguigu.test;

import com.atguigu.ioc_03.A;
import com.atguigu.ioc_03.HappyComponent;
import com.atguigu.ioc_04.JavaBean2;
import com.atguigu.ioc_05.JavaBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIocTest {
    /**
     * 模拟spring的ioc容器并读取配置文件
     */
    public void createIoc(){
        // 创建容器 选择合适的容器实现
        /**
         * 接口
         *    BeanFactory
         *    ApplicationContext
         * 实现类
         *    ClassPathXmlApplicationContext
         *    FileSystemXmlApplicationContext（不推荐）
         *    AnnotationConfigApplicationContext
         *    WebApplicationContext
         */
        // 方式1：直接创建容器并且指定配置文件即可 先进行 mvn compile
        // 构造函数(string...配置文件) 可以填写一个或多个
        // ioc di
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-03.xml");

        // 方式2：先创建ioc容器对象，在指定配置文件，再刷新
        // 源码的配置过程  创建容器[spring]和配置文件指定分开[自己指定]
        ClassPathXmlApplicationContext applicationContext1 = new ClassPathXmlApplicationContext();
        applicationContext1.setConfigLocations("spring-03.xml");
        applicationContext1.refresh();  // 调用ioc和di的流程

    }

    /**
     * 从ioc容器中获取组件bean
     */
    @Test
    public void getBeanFromIoc(){
        // 1.创建ioc容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext();
        applicationContext.setConfigLocations("spring-03.xml");
        applicationContext.refresh();

        // 2.读取ioc容器的组件
        // 方式1：根据组件id获取 返回值类型是object 需要强转 [不推荐]
        HappyComponent happyComponent = (HappyComponent) applicationContext.getBean("happyComponent");
        // 方式2：根据beanId，同时指定bean的类型Class
        HappyComponent happyComponent1 = applicationContext.getBean("happyComponent",HappyComponent.class);
        // 方式3：直接根据bean的类型Class
        // TODO: 同一个类型在ioc容器中只能有一个bean
        // TODO: 当容器中存在多个类型相同的bean时会报错，NoUniqueBeanDefinitionException
        // TODO: ioc的配置一定是实现类，但是可以根据接口类型获取值
        // TODO: getBean(类型); instanceof ioc的类型 == true
        HappyComponent happyComponent2 = applicationContext.getBean(HappyComponent.class);

        happyComponent2.doWork();
        System.out.println(happyComponent == happyComponent1);
        System.out.println(happyComponent1 == happyComponent2);

        // 根据接口类型获取bean
        A happyComponent3 = applicationContext.getBean(A.class);
        happyComponent3.doWork();

    }

    @Test
    public void test_04(){
        // 1.创建ioc容器 就会进行组件对象的实例化 -> init
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-04.xml");

        // 3.单例 scope=singleton     输出结果是true
        //   多例 scope=prototype     输出结果是false
        JavaBean2 bean = applicationContext.getBean(JavaBean2.class);
        JavaBean2 bean2 = applicationContext.getBean(JavaBean2.class);
        System.out.println(bean == bean2);

        // 2.正常结束ioc容器
        applicationContext.close();
    }

    @Test
    public void test_05(){
        // 1.创建ioc实例
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-05.xml");

        // 2.
        JavaBean javabean = applicationContext.getBean("javaBean", JavaBean.class);
        System.out.println("javaBean = "+javabean);

        // TODO: FactoryBean工厂也会加入到ioc容器
        Object bean = applicationContext.getBean("&javaBean");
        System.out.println("bean" + bean);



    }

}
