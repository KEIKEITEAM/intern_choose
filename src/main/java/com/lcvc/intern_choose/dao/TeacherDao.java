package com.lcvc.intern_choose.dao;

import com.lcvc.intern_choose.model.Student;
import com.lcvc.intern_choose.model.Teacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherDao extends IBaseDao<Teacher>{

    /**
     * 处理数据库的登录方法
     * @param teacherNumber 工号
     * @param password 密码
     * @return 返回匹配的账户总数
     */
    int login(@Param(value = "teacherNumber") String teacherNumber, @Param(value = "password") String password);

    /**
     * 用于查询所有并返回所有的Student方法
     * @return  返回查询到的Student集合
     */
    List<Student> readAll();

    /**
     * 查询指定的Teacher
     * @param teacherNumber
     * @return 返回指定的Teacher
     */
    Teacher get(@Param("teacherNumber") String teacherNumber);

    /**
     * 添加Teacher方法
     * @param teacher
     * @return 返回1表示添加成功，0表示失败
     */
    int save(Teacher teacher);

    /**
     * 修改Teacher方法
     * @param teacher
     * @return  返回1表示修改成功，0表示失败
     */
    int update(Teacher teacher);

    /**
     * 删除Teacher方法
     * @param teacherNumber
     * @return 返回1表示删除成功，0表示失败
     */
    int delete(@Param("teacherNumber") String teacherNumber);



}
