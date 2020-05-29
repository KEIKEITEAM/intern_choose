package com.lcvc.intern_choose.dao;


import com.lcvc.intern_choose.model.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao extends IBaseDao<Student>{

    /**
     * 处理数据库的登录方法
     * @param studentNumber 学号
     * @param password 密码
     * @return 返回匹配的账户总数
     */
    int login(@Param(value = "studentNumber") String studentNumber, @Param(value = "password") String password);


    /**
     * 用于查询所有并返回所有的Student方法
     * @return  返回查询到的Student集合
     */
    List<Student> readAll();

    /**
     * 查询指定的Student
     * @param studentNumber
     * @return 返回指定的Student
     */
    Student get(@Param("studentNumber") String studentNumber);

    /**
     * 添加Student方法
     * @param student
     * @return 返回1表示添加成功，0表示失败
     */
    int save(Student student);

    /**
     * 修改Student方法
     * @param student
     * @return  返回1表示修改成功，0表示失败
     */
    int update(Student student);

    /**
     * 删除Classes方法
     * @param studentNumber
     * @return 返回1表示删除成功，0表示失败
     */
    int delete(@Param("studentNumber") String studentNumber);



}
