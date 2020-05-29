package com.lcvc.intern_choose.dao;

import com.lcvc.intern_choose.model.Grades;
import com.lcvc.intern_choose.model.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao extends IBaseDao<Student>{
    /**
     * 查询所有Grades
     * @return 返回Grades对象集合
     */
    List<Student> readAll();

    /**
     * 查询指定的Grades
     * @param studentNumber
     * @return 返回查询的结果，1表示成功，0表示失败
     */
    Student get(@Param("studentNumber") String studentNumber);

    /**
     * 添加Grades的方法
     * @param student
     * @return 返回添加的结果，1表示成功，0表示失败
     */
    int save(Student student);

    /**
     * 修改Grades的方法
     * @param student
     * @return 返回修改的结果，1表示成功，0表示失败
     */
    int update(Student student);

    int delete(@Param("studentNumber") String studentNumber);

}
