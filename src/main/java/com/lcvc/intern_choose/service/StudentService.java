package com.lcvc.intern_choose.service;

import com.lcvc.intern_choose.model.Student;
import com.lcvc.intern_choose.model.Teacher;
import com.lcvc.intern_choose.model.TeacherProfessionalGrade;
import com.lcvc.intern_choose.model.base.PageObject;
import com.lcvc.intern_choose.model.form.StudentPasswordForm;
import com.lcvc.intern_choose.model.query.StudentQuery;

import javax.validation.constraints.NotNull;
import java.text.ParseException;
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
    void choose(String studentNumber,String teacherNumber) throws ParseException;

    /**
     * 获取选择的实习老师的信息
     * @param studentNumber
     * @return
     */
    Teacher getTeacher(String studentNumber);

    /**
     * 获取可供学生选择的教师集合
     * @param classesId 班级Id
     * @return
     */
    List<TeacherProfessionalGrade>getAvailableTeacher(Integer classesId);

    /**
     * 分页获取该表全部数据
     * @return
     */
    PageObject query (Integer page, Integer limit, StudentQuery studentQuery);

    /**
     * 修改密码
     * @param studentPasswordForm
     * @return
     */
    Boolean updatePassword(StudentPasswordForm studentPasswordForm, String studentNumber);
}
