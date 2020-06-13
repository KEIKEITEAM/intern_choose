package com.lcvc.intern_choose.service;

import com.lcvc.intern_choose.model.TeacherStudent;
import com.lcvc.intern_choose.model.base.PageObject;
import com.lcvc.intern_choose.model.query.TeacherStudentQuery;

import java.util.List;

/**
 * @author liang
 */
public interface TeacherStudentService {

    List<TeacherStudent> readAll(TeacherStudentQuery teacherStudentQuery);

    TeacherStudent get(Integer id);

    Boolean save(TeacherStudent teacherStudent);

    Boolean update(TeacherStudent teacherStudent);

    Boolean delete(Integer id);

    /**
     * 分页获取该表全部数据
     *
     * @return
     */
    PageObject query(Integer page, Integer limit, TeacherStudentQuery teacherStudentQuery);

    /**
     * 根据teacherNumber和professionalGradeId查询TeacherStudent集合
     *
     * @param teacherNumber
     * @param professionalGradeId
     * @param page
     * @param limit
     * @return
     */
    PageObject getByTeacherNumber(String teacherNumber,
                                  Integer professionalGradeId,
                                  Integer page,
                                  Integer limit);

    /**
     * 批量添加
     *
     * @param studentNumbers
     * @param tpgId
     * @return
     */
    int batchAdd(String studentNumbers, Integer tpgId);

    /**
     * 随机分配未选择实习老师的学生
     *
     * @param tpgId
     * @return 成功记录数
     */
    String randomChooseStudent(Integer tpgId);
}

