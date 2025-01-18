package com.atguigu.mapper;

import com.atguigu.pojo.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {
    // 根据id查询员工信息
    Employee queryById(Integer id);

    // 如果是我们dml语句(插入 修改 删除)
    int deleteById(Integer id);

    // 指定输出类型 查询语句
    // 根据员工的id查询员工的姓名
    String queryNameById(Integer id);
    // 根据员工的id查询员工的工资
    Double querySalaryById(Integer id);
    // 查询部门的最高工资和平均工资
    Map<String,Object> selectEmpNameAndMaxSalary();

    // 查询工资高于200的员工姓名们
    List<String> queryNameBySalary(Double salary);
    // 查询全部员工信息
    List<Employee> queryAll();

    // 员工插入
    int insertEmp(Employee employee);

    // 根据员工id查询员工信息
    Employee selectEmployeeByRM(Integer empId);
}
