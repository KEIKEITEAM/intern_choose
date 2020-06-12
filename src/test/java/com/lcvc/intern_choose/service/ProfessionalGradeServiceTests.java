package com.lcvc.intern_choose.service;

import com.lcvc.intern_choose.model.ProfessionalGrade;
import com.lcvc.intern_choose.model.query.ProfessionalGradeQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class ProfessionalGradeServiceTests {
    @Autowired
    private ProfessionalGradeService professionalGradeService;
    @Test
    void readAll() {
        professionalGradeService.readAll(null).forEach(System.out::println);
    }

    @Test
    void get() {
        System.out.println(professionalGradeService.get(1));
    }

    @Test
    void save() {
        ProfessionalGradeQuery professionalGradesave=new ProfessionalGradeQuery();
        professionalGradesave.setProfessionalId(3);
        professionalGradesave.setGradeId(1);
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
        professionalGradesave.setOpen(false);
        professionalGradesave.setAvailableOpen(false);
        System.out.println(professionalGradeService.save(professionalGradesave));
    }

    @Test
    void update() throws ParseException {
        ProfessionalGrade professionalGradesave=new ProfessionalGrade();
        professionalGradesave.setId(16);
        professionalGradesave.setProfessionalId(3);
        professionalGradesave.setGradeId(1);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date star = null;
//        Date end = null;
//        try {
//            star= sdf.parse("2020-07-09");
//            end = sdf.parse("2020-07-20");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        professionalGradesave.setStartTime(star);
//        professionalGradesave.setEndTime(end);
//        professionalGradesave.setOpen(false);
        System.out.println(professionalGradeService.update(professionalGradesave));
    }

    @Test
    void delete() {
        System.out.println(professionalGradeService.delete(13));
    }

    @Test
    void getProfessionalGradeByTeacherNumber(){
        System.out.println(professionalGradeService.getProfessionalGradeByTeacherNumber("2006000002"));
    }
}