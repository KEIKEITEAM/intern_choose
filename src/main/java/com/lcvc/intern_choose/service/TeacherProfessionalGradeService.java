package com.lcvc.intern_choose.service;

import com.lcvc.intern_choose.model.TeacherProfessionalGrade;
import com.lcvc.intern_choose.model.base.PageObject;
import com.lcvc.intern_choose.model.query.TeacherProfessionalGradeQuery;

import java.util.List;

/**
 * @author liang
 */
public interface TeacherProfessionalGradeService {
    List<TeacherProfessionalGrade> readAll(Object object);

    TeacherProfessionalGrade get(Integer id);

    Boolean save(TeacherProfessionalGrade teacherProfessionalGrade);

    Boolean update(TeacherProfessionalGrade teacherProfessionalGrade);

    Boolean delete(Integer id);

    /**
     * 分页获取该表全部数据
     * @return
     */
    PageObject query (Integer page, Integer limit, TeacherProfessionalGradeQuery teacherProfessionalGradeQuery);

    /**
     * 获取不够实习学生的老师
     * @param page
     * @param limit
     * @return
     */
    PageObject getNotEnough(Integer page, Integer limit);
}
