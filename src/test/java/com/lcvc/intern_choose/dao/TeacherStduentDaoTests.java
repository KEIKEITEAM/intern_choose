package com.lcvc.intern_choose.dao;

import com.lcvc.intern_choose.model.TeacherStudent;
import com.lcvc.intern_choose.model.query.TeacherStudentQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class TeacherStduentDaoTests {
    @Autowired
    private TeacherStudentDao teacherStudentDao;

    @Test
    void save(){
        TeacherStudent teacherStudent=new TeacherStudent();
        teacherStudent.setStudentNumber("123123");
        teacherStudent.setTpgId(1);
        System.out.println(teacherStudentDao.save(teacherStudent));
    }
    @Test
    void getByTeacherAndProfessionalGrade(){
        TeacherStudentQuery teacherStudentQuery=new TeacherStudentQuery();
        teacherStudentQuery.setTpgId(1);
        //teacherStudentQuery.setStudentNumber("123");
        System.out.println(teacherStudentDao.readAll(teacherStudentQuery));
    }

    @Test
    void test() {
        System.out.println(teacherStudentDao.getByStudentNumber("123"));
    }
}
