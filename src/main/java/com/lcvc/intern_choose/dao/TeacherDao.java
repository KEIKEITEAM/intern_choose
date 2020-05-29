package com.lcvc.intern_choose.dao;

import com.lcvc.intern_choose.model.Teacher;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherDao extends IBaseDao<Teacher>{

    /**
     * 处理数据库的登录方法
     * @param teacherNumber 工号
     * @param password 密码
     * @return 返回匹配的账户总数
     */
    int login(@Param(value = "teacherNumber") String teacherNumber, @Param(value = "password") String password);


}
