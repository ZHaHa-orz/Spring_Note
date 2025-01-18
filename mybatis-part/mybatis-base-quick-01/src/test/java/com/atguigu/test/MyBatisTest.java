package com.atguigu.test;

import com.atguigu.mapper.EmployeeMapper;
import com.atguigu.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisTest {
    /**
     * MyBatis提供的api进行方法的调用
     *      jdbcTemplate: new JdbcTemplate(dataSource)
     */
    @Test
    public void test_01() throws IOException {
        // 1.创建SqlSessionFactory对象
        // ①声明Mybatis全局配置文件的路径
        String mybatisConfigFilePath = "mybatis-config.xml";

        // ②以输入流的形式加载Mybatis配置文件
        InputStream inputStream = Resources.getResourceAsStream(mybatisConfigFilePath);

        // ③基于读取Mybatis配置文件的输入流创建SqlSessionFactory对象
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 2.使用SqlSessionFactory对象开启一个会话
        // openSession()方法默认开启一个事务,默认是不会自动提交事务 需要session.commit()提交事务
        // openSession(true) 自动提交
        SqlSession session = sessionFactory.openSession();

        // 3.根据EmployeeMapper接口的Class对象获取Mapper接口类型的对象(动态代理技术)
        // jdk动态代理技术生成的mapper代理对象
        // 内部拼接接口的全限定符号.方法名 去查找对应的sql语句
        // 1.拼接 类的全限定名.方法名 整合参数 -> ibatis对应的方法传入参数  mybatis底层调用ibatis
        // 2.根据方法名获取对应的sql语句标签
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        // 在ibatis中 session 还提供curd 方法进行数据库查询操作
        // selectOne  selectList | insert | update | delete 查询对应的sql语句标签
        // 参数1: 字符串: sql标签对应的标识  id | namespace.id
        // 参数2: Object 执行sql语句传入的参数
        // Employee employee = session.selectOne("getEmpById", 1);
        // System.out.println("employee = " + employee);

        // 4. 调用代理类方法既可以触发对应的SQL语句
        Employee employee = employeeMapper.getEmpById(1);

        System.out.println("employee = " + employee);

        // 4.关闭SqlSession
        session.commit(); //提交事务 [DQL不需要,其他需要]
        session.close(); //关闭会话
    }


}
