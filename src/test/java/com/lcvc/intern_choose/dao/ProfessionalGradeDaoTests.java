package com.lcvc.intern_choose.dao;

import com.lcvc.intern_choose.model.query.ProfessionalGradeQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
public class ProfessionalGradeDaoTests {
    @Autowired
    private ProfessionalGradeDao professionalGradeDao;

    @Test
    void getByProfessionalGrade(){
        ProfessionalGradeQuery professionalGradeQuery=new ProfessionalGradeQuery();

        professionalGradeQuery.setGradeId(1);
        professionalGradeQuery.setOpen(true);
        professionalGradeQuery.setAvailableOpen(true);
        System.out.println(professionalGradeDao.readAll(professionalGradeQuery));
        System.out.println(professionalGradeDao.get(1));
    }


    @Test
    void save(){
        ProfessionalGradeQuery professionalGradesave=new ProfessionalGradeQuery();
        professionalGradesave.setProfessionalId(1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date star = null;
        Date end = null;
        try {
            star= sdf.parse("1992-07-06");
             end = sdf.parse("2020-07-09");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        professionalGradesave.setStartTime(star);
        professionalGradesave.setEndTime(end);
        professionalGradesave.setGradeId(1);
        professionalGradesave.setOpen(false);
        professionalGradesave.setAvailableOpen(false);

        professionalGradeDao.save(professionalGradesave);
    }

    @Test
    void delete(){
        System.out.println(professionalGradeDao.delete(12));
    }
}
