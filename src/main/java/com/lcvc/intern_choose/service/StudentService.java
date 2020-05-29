package com.lcvc.intern_choose.service;

import com.lcvc.intern_choose.model.Student;
import com.lcvc.intern_choose.model.Student;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface StudentService {




    /**
     * 登录方法
     *
     * @param username 账户名，不能为空
     * @param password 密码，不能为空
     * @return null表示登录失败
     */
    boolean login(String username, String password);

    /**
     * 根据ID查询该表数据
     * @param id
     * @return
     */
    Student get(String teacherNumber);

    /**
     * 获取该表全部数据
     * @return
     */
    List<Student> readAll();

    /**
     * 根据ID删除该表数据
     * @param id
     * @return
     */
    Boolean delete(@NotNull String studentNumber);

    /**
     * 根据ID修改该表数据
     * @param
     * @return
     */
    boolean update(Student Student);

    /**
     * 添加数据
     * @param
     * @return
     */
    boolean  save(Student Student);



}
