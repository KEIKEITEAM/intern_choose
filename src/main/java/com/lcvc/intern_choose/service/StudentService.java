package com.lcvc.intern_choose.service;

import com.lcvc.intern_choose.model.Student;
import com.lcvc.intern_choose.model.query.StudentQuery;

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
     * 根据teacherNumber查询
     * @return
     */
    Student get(String teacherNumber);

    /**
     * 获取该表全部数据
     * @return
     */
    List<Student> readAll(StudentQuery studentQuery);

    /**
     * 根据teacherNumber删除该表数据
     * @param teacherNumber
     * @return
     */
    Boolean delete(@NotNull String teacherNumber);

    /**
     * 根据ID修改该表数据
     * @param student
     * @return
     */
    boolean update(Student student);

    /**
     * 添加数据
     * @param student
     * @return
     */
    boolean  save(Student student);

    /**
     *实习学生选择实习老师
     */
    boolean choose(String studentNumber,Integer tpgId);
}
