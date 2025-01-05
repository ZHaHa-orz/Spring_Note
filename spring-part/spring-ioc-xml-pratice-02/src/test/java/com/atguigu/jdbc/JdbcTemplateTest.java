package com.atguigu.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import com.atguigu.controller.StudentController;
import com.atguigu.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcTemplateTest {
    @Test
    public void testForJava() {
        /** java代码连接数据库
         * JdbcTemplate 简化数据库的crud 不提供连接池
         * DruidDataSource 负责连接的创建和数据库驱动的注册等等
         */
        // 0.创建一个连接池对象
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/studb");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        // 1.实例化对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);

        // 2.调用方法
        // jdbcTemplate.update()    DDL DML DCL...非查询语句
        // jdbcTemplate.queryForObject()    DQL 查询单个对象
        // jdbcTemplate.query()     DQL 查询集合
    }

    @Test
    public void testForIoc() {
        // 1.创建ioc容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-01.xml");

        // 2.获取bean
        JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);

        // 3.调用方法 进行数据库的curd动作
        // 3.1 插入 删除 和 修改 DML update
        String sql = "insert into students (id,name,gender,age,class) values (?,?,?,?,?);";
        /**
         * 参数1: String sql 可以带占位符？ ？只能替代值 不能替代关键字和容器名
         * 参数2: Object...param 传入占位符的值 顺序 从左开始对象
         * 返回值int类型，表示影响的行数
         */
        int rows = jdbcTemplate.update(sql, 9, "小明", "男", 18, "三年二班");
        System.out.println("rows = " + rows);
        // 3.2 查询单个对象 DQL queryForObject
        // 根据id查询
        sql = "select * from students where id = ? ;";
        /**
         * 参数1: sql 语句 可以使用?
         * 参数2: RowMapper 列名和属性名的映射器接口
         * 参数3: Object...param 可以变参数占位符的值
         * 返回值 rowMapper 指定的对象
         */
        Student student1 = jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
            // rs 代表结果集
            // rowNum 表示当前行号
            // rs 结果集中获取列的值 赋值给实体类对象
            Student student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setGender(rs.getString("gender"));
            student.setAge(rs.getInt("age"));
            student.setClasses(rs.getString("class"));
            return student;
        }, 1);
        System.out.println("student1 = " + student1);

        // 3.3 查询所有学生的数据
        sql = "select id, name, gender, age, class as classes from students ;";
        /**
         * 参数1: sql 语句 可以使用?
         * 参数2: RowMapper 列名和属性名的映射器接口
         * 返回值 List<rowMapper>
         */
        // TODO: BeanPropertyRowMapper<T> 帮助我们自动映射列和属性值！要求列名和属性名一致，若不一致可以起别名
        List<Student> studentList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Student>(Student.class));
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void testQueryAll() {
        // 1.创建ioc容器
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-02.xml");
        // 2.获取组件对象
        StudentController controller = applicationContext.getBean(StudentController.class);
        // 3.使用组件对象
        controller.findAll();
        // 4.关闭容器
        applicationContext.close();
    }
}
