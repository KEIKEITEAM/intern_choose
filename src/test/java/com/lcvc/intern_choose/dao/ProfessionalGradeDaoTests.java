package com.lcvc.intern_choose.dao;

import com.lcvc.intern_choose.model.query.ProfessionalGradeQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProfessionalGradeDaoTests {
    @Autowired
    private ProfessionalGradeDao professionalGradeDao;

    @Test
    void getByProfessionalGrade(){
        ProfessionalGradeQuery professionalGradeQuery=new ProfessionalGradeQuery();
        professionalGradeQuery.setProfessionalId(1);
        professionalGradeQuery.setGradeId(1);
        professionalGradeQuery.setOpen(true);
        professionalGradeQuery.setAvailableOpen(true);
        System.out.println(professionalGradeDao.readAll(professionalGradeQuery));
        System.out.println(professionalGradeDao.get(1));
    }

    @Test
    void test(){


    }
}
