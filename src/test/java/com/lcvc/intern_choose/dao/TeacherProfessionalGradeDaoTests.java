package com.lcvc.intern_choose.dao;

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
}
