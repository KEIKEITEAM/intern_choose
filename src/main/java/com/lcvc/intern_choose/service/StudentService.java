package com.lcvc.intern_choose.service;

import com.lcvc.intern_choose.model.Student;

public interface StudentService {


    Student get(String teacherNumber);

    /**
     * 登录方法
     *
     * @param username 账户名，不能为空
     * @param password 密码，不能为空
     * @return null表示登录失败
     */
    boolean login(String username, String password);

    
}
