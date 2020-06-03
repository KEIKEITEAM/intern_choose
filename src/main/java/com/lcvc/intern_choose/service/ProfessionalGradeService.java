package com.lcvc.intern_choose.service;

import com.lcvc.intern_choose.model.ProfessionalGrade;

import java.util.List;

public interface ProfessionalGradeService {
    List<ProfessionalGrade> readAll(Object object);

    ProfessionalGrade get(Integer id);

    Boolean save(ProfessionalGrade professionalGrade);

    Boolean update(ProfessionalGrade professionalGrade);

    Boolean delete(Integer id);

}
