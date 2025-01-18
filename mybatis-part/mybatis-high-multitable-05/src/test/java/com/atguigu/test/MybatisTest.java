package com.atguigu.test;

import com.atguigu.mapper.CustomerMapper;
import com.atguigu.mapper.OrderMapper;
import com.atguigu.pojo.Customer;
import com.atguigu.pojo.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class MybatisTest {
    private SqlSession sqlSession;

    @BeforeEach
    public void before() throws IOException {
        sqlSession = new SqlSessionFactoryBuilder()
                .build(
                        Resources.getResourceAsStream("mybatis-config.xml"))
                .openSession();
    }

    @Test
    public void test01(){
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        Order order = mapper.queryOrderById(1);
        System.out.println("=================================");
        System.out.println("order = " + order);
        System.out.println("order.getCustomer() = " + order.getCustomer());
        System.out.println("=================================");
    }

    @Test
    public void test02(){
        CustomerMapper mapper = sqlSession.getMapper(CustomerMapper.class);
        List<Customer> customers = mapper.queryList();
        System.out.println("=================================");
        System.out.println("customers = " + customers);
        for (Customer customer : customers) {
            System.out.println("-------------------------------------");
            System.out.println("customer" + customer.getCustomerId() + " = " + customer);
            for (Order order : customer.getOrderList()){
                System.out.println("order" + order.getOrderId() + " = " +order);
            }
        }
        System.out.println("=================================");
    }










    @AfterEach
    public void after() {
        sqlSession.close();
    }
}
