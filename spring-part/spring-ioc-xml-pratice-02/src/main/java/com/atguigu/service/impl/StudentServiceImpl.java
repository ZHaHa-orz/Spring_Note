package com.atguigu.service.impl;

import com.atguigu.pojo.Student;
import com.atguigu.service.StudentService;
import com.atguigu.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 实现类
@Service
public class StudentServiceImpl  implements StudentService {

    @Autowired
    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    /**
     * 查询全部学员业务
     * @return
     */
    @Override
    public List<Student> findAll() {

        List<Student> studentList =  studentDao.queryAll();
        System.out.println("studentService:"+studentList);
        return studentList;
    }
}
