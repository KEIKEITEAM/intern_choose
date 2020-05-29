package com.lcvc.intern_choose.service;

import com.lcvc.intern_choose.model.Teacher;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface TeacherService {


    Teacher get(String teacherNumber);

    /**
     * 登录方法
     *
     * @param username 账户名，不能为空
     * @param password 密码，不能为空
     * @return null表示登录失败
     */
    boolean login(String username, String password);

    /**
     * 获取该表全部数据
     * @return
     */
    List<Teacher> readAll();

    /**
     * 根据ID删除该表数据
     * @param teacherNumber不能为空
     * @return
     */
    Boolean delete(@NotNull String teacherNumber);

    /**
     * 根据ID修改该表数据
     * @param
     * @return
     */
    boolean update(Teacher teacher);

    /**
     * 添加数据
     * @param
     * @return
     */
    boolean  save(Teacher teacher);
}
