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
     * @return
     */
    PageObject query (Integer page, Integer limit, TeacherStudentQuery teacherStudentQuery);
}

