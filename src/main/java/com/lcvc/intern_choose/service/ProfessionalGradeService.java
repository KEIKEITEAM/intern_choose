package com.lcvc.intern_choose.service;

import com.lcvc.intern_choose.model.ProfessionalGrade;
import com.lcvc.intern_choose.model.base.PageObject;
import com.lcvc.intern_choose.model.query.ProfessionalGradeQuery;

import java.text.ParseException;
import java.util.List;

public interface ProfessionalGradeService {
    List<ProfessionalGrade> readAll(Object object);

    /**
     * 分页获取该表全部数据
     * @return
     */
    PageObject query (Integer page, Integer limit, ProfessionalGradeQuery professionalGradeQuery);

    ProfessionalGrade get(Integer id);

    Boolean save(ProfessionalGrade professionalGrade);

    Boolean update(ProfessionalGrade professionalGrade) throws ParseException;

    Boolean delete(Integer id);

    /**
     * 根据teacherNumber获取ProfessionalGrade集合
     * @param teacherNumber
     * @return
     */
    List<ProfessionalGrade> getProfessionalGradeByTeacherNumber(String teacherNumber);
}
