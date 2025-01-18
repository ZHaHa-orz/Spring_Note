package com.atguigu.mapper;

import com.atguigu.pojo.Employee;

public interface EmployeeMapper {
    Employee getEmpById(Integer id);
    int deleteById(Integer id);
}
