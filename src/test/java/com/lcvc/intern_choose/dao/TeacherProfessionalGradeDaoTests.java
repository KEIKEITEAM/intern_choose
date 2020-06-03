package com.lcvc.intern_choose.dao;

import com.lcvc.intern_choose.model.Teacher;
import com.lcvc.intern_choose.model.TeacherProfessionalGrade;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TeacherProfessionalGradeDaoTests {
    @Autowired
    private TeacherProfessionalGradeDao teacherProfessionalGradeDao;

    @Test
    void getByTeacherAndProfessionalGrade(){

    }

    @Test
    void get(){
        System.out.println(teacherProfessionalGradeDao.get(1));
    }

    @Test
    void save(){
        TeacherProfessionalGrade teacherProfessionalGrade = new TeacherProfessionalGrade();
        teacherProfessionalGrade.setProfessionalGradeId(1);
        teacherProfessionalGrade.setStudentQuantity(1);
        teacherProfessionalGrade.setTeacher(new Teacher());
        teacherProfessionalGrade.setTeacherNumber("1");
        System.out.println(teacherProfessionalGradeDao.save(teacherProfessionalGrade));
    }

    @Test
    void update(){
        TeacherProfessionalGrade teacherProfessionalGrade = new TeacherProfessionalGrade();
        teacherProfessionalGrade.setProfessionalGradeId(1);
        teacherProfessionalGrade.setStudentQuantity(1);
        teacherProfessionalGrade.setTeacherNumber("100");
        teacherProfessionalGrade.setId(1);
        System.out.println(teacherProfessionalGradeDao.save(teacherProfessionalGrade));
    }

    @Test
    void delete(){
        System.out.println(teacherProfessionalGradeDao.delete(1));
    }
}
