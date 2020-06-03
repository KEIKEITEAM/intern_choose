package com.lcvc.intern_choose.service;

import com.lcvc.intern_choose.model.TeacherProfessionalGrade;

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
}
