package com.lcvc.intern_choose.dao;

import com.lcvc.intern_choose.model.Teacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherDao extends IBaseDao<Teacher>{
    /**
     * 查询所有Teacher
     * @return 返回Teacher对象集合
     */
    List<Teacher> readAll();

    /**
     * 查询指定的Teacher
     * @param teacherNumber
     * @return 返回查询的结果，1表示成功，0表示失败
     */
    Teacher get(@Param("teacherNumber") String teacherNumber);

    /**
     * 添加Teacher的方法
     * @param teacher
     * @return 返回添加的结果，1表示成功，0表示失败
     */
    int save(Teacher teacher);

    /**
     * 修改Teacher的方法
     * @param teacher
     * @return 返回修改的结果，1表示成功，0表示失败
     */
    int update(Teacher teacher);

    int delete(@Param("teacherNumber") String teacherNumber);


}
