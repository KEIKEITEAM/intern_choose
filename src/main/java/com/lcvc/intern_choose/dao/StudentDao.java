package com.lcvc.intern_choose.dao;

import com.lcvc.intern_choose.model.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao extends IBaseDao<Student>{

    /**
     * 处理数据库的登录方法
     * @param studentNumber 学号
     * @param password 密码
     * @return 返回匹配的账户总数
     */
    int login(@Param(value = "studentNumber") String studentNumber, @Param(value = "password") String password);

}
