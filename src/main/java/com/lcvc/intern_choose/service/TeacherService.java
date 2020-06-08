package com.lcvc.intern_choose.service;

import com.lcvc.intern_choose.model.Teacher;
import com.lcvc.intern_choose.model.base.PageObject;
import com.lcvc.intern_choose.model.form.TeacherPasswordForm;
import com.lcvc.intern_choose.model.query.TeacherQuery;

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
     * @param teacherNumber
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




    /**
     * 分页获取该表全部数据
     * @return
     */
    PageObject query (Integer page, Integer limit, TeacherQuery teacherQuery);

    /**
     * 修改密码
     * @param teacherPasswordForm
     * @return
     */
    Boolean updatePassword(TeacherPasswordForm teacherPasswordForm, String teacherNumber);

}
