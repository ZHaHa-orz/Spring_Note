package com.atguigu.mapper;

import com.atguigu.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    // 1.if where set
    // 根据姓名和工资范围查询员工信息
    List<Employee> query(@Param("name")String name, @Param("salary")Double salary);
    // 根据员工id修改员工信息
    int update(Employee employee);

    // 2.trim
    List<Employee> queryTrim(@Param("name")String name, @Param("salary")Double salary);
    int updateTrim(Employee employee);

    // 3.choose when otherwise
    //根据两个条件查询，如果姓名不为nu11使用姓名查询，如果姓名为nu11,薪水不为空就使用薪水查询! 都为nu11查询全部
    List<Employee> queryChoose(@Param("name")String name, @Param("salary")Double salary);

    // 4.foreach
    // 根据id批量查询
    List<Employee> queryBatch(@Param("ids") List<Integer> ids);
    // 根据id批量删除
    int deleteBatch(@Param("ids") List<Integer> ids);
    // 根据id批量插入
    int insertBatch(@Param("employeeList") List<Employee> employeeList);
    // 根据id批量修改
    int updateBatch(@Param("employeeList") List<Employee> employeeList);
}
