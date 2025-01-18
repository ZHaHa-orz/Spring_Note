package com.atguigu.test;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    private SqlSession sqlSession;
    @BeforeEach // 在测试方法执行前执行
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        sqlSession = sqlSessionFactory.openSession(true);
    }
    @AfterEach // 在测试方法执行后执行
    public void destory() {
        sqlSession.close();
    }

    @Test
    public void testInsert() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("zhh");
        user.setPassword("123456");
        int insert = mapper.insert(user);
        System.out.println("=================================");
        System.out.println("insert = " + insert);
    }
    @Test
    public void testUpdate() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(1);
        user.setUsername("root");
        user.setPassword("123456");
        int update = mapper.update(user);
        System.out.println("=================================");
        System.out.println("update = " + update);
    }
    @Test
    public void testDelete() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int delete = mapper.delete(1);
        System.out.println("=================================");
        System.out.println("delete = " + delete);
    }
    @Test
    public void testSelectById() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectById(1);
        System.out.println("=================================");
        System.out.println("user = " + user);
    }
    @Test
    public void testSelectAll() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.selectAll();
        System.out.println("=================================");
        for (User user : users) {
            System.out.println("user = " + user);
        }
    }

}
