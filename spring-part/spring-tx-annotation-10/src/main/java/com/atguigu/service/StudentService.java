package com.atguigu.service;

import com.atguigu.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

@Transactional
@Service
public class StudentService {
    
    @Autowired
    private StudentDao studentDao;

    public void changeInfo1(){
        studentDao.updateAgeById(10,1);
        System.out.println("-----------");
        studentDao.updateNameById("test1",1);
    }

    /**
     * 添加事务：
     *      方法 | 类上 @Transactional
     *      方法：当前方法有事务
     *      类：当前类所有方法都有事务
     * 解释：一般情况下，都是通过类添加注解添加事务
     *      查询方法可以通过再次添加注解，设置为只读模式，提高效率
     */

    @Transactional
    public void changeInfo2(){
        studentDao.updateAgeById(20,1); // 回滚 不会修改数据库的值
        int i = 10/0;
        System.out.println("-----------");
        studentDao.updateNameById("test2",1);
    }

    /**
     * 1. 只读模式
     *      只读模式可以提升查询事务的效率
     *      默认：boolean readOnly() default false;
     */
    @Transactional(readOnly = true)
    public void getStudentInfo(){
        // 查询 没必要添加事务
        // 获取学生信息 查询数据库 不修改
    }

    /**
     * 2. 超时设置
     *      默认：int timeout() default -1; 用不超时
     *      timeout = 时间 秒 超过时间，就会会滚事务和抛出异常 TransactionTimedOutException
     *      如果在类上设置事务属性，方法也设置了事务注解，方法不会生效
     *      方法上的注解会覆盖类上的注解
     */
    @Transactional(timeout = 3)
    public void changeInfo3(){
        studentDao.updateAgeById(30,1); // 回滚 不会修改数据库的值
        try{
            Thread.sleep(4000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        System.out.println("-----------");
        studentDao.updateNameById("test3",1);
    }

    /**
     * 3. 指定异常回滚和指定异常不回滚
     *      默认情况下，指定发生运行时异常RuntimeException时事务才会回滚
     *      可以指定Exception异常来控制所有异常都回滚
     *      rollbackFor = Exception.class
     *      noRollbackFor = 回滚异常范围内，控制某个异常不回滚
     */
    @Transactional(rollbackFor = Exception.class, noRollbackFor = FileNotFoundException.class)
    public void changeInfo4() throws FileNotFoundException {
        studentDao.updateAgeById(40,1); // 不会回滚, age设置成功
        new FileInputStream("xxxx");
        System.out.println("-----------");
        studentDao.updateNameById("test4",1);
    }

    /**
     * 4. 隔离级别设置
     *      推荐设置第二个隔离级别
     */
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void changeInfo5() {
        studentDao.updateAgeById(50,1); //
        System.out.println("-----------");
        studentDao.updateNameById("test5",1);
    }

    /**
     * 5. 嵌套事务-事务传播行为
     *      默认值：Propagation.REQUIRED：如果父方法有事务，就加入，如果没有就新建自己独立！
     *      propagation = Propagation.REQUIRES_NEW：不管父方法是否有事务，我都新建事务，都是独立的！
     */
    // 通过TopService调用changeAge和changeName方法
    // 声明两个独立修改数据库的事务业务方法
    // Propagation.REQUIRES
    @Transactional(propagation = Propagation.REQUIRED)
    public void changeAge(){
        studentDao.updateAgeById(60,1); // 回滚
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public void changeName(){
        studentDao.updateNameById("test6",1);
        int i = 1/0;
    }

    // Propagation.REQUIRES_NEW
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void changeAge2(){
        studentDao.updateAgeById(70,1); // 事务独立 不会回滚
    }
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void changeName2(){
        studentDao.updateNameById("test7",1);
        int i = 1/0;
    }
}
