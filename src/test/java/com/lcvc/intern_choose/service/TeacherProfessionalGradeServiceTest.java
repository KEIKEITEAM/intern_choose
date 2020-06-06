package com.lcvc.intern_choose.service;

import com.lcvc.intern_choose.model.TeacherProfessionalGrade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TeacherProfessionalGradeServiceTest {
    @Autowired
    private TeacherProfessionalGradeService teacherProfessionalGradeService;

    @Test
    void readAll() {
        teacherProfessionalGradeService.readAll(null).forEach(System.out::println);
    }

    @Test
    void get() {
        System.out.println(teacherProfessionalGradeService.get(2));
    }

    @Test
    void save() {
        TeacherProfessionalGrade teacherProfessionalGrade = new TeacherProfessionalGrade();
        teacherProfessionalGrade.setProfessionalGradeId(1);
        teacherProfessionalGrade.setStudentQuantity(10);
        teacherProfessionalGrade.setTeacherNumber("2006010006");
        System.out.println(teacherProfessionalGradeService.save(teacherProfessionalGrade));
    }

    @Test
    void update() {
        TeacherProfessionalGrade teacherProfessionalGrade = new TeacherProfessionalGrade();
        teacherProfessionalGrade.setId(4);
        teacherProfessionalGrade.setProfessionalGradeId(1);
        teacherProfessionalGrade.setStudentQuantity(5);
        teacherProfessionalGrade.setTeacherNumber("15000");
        System.out.println(teacherProfessionalGradeService.update(teacherProfessionalGrade));
    }

    @Test
    void delete() {
        System.out.println(teacherProfessionalGradeService.delete(4));
    }
}