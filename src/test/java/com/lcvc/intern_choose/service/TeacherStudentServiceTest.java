package com.lcvc.intern_choose.service;

import com.lcvc.intern_choose.dao.TeacherStudentDao;
import com.lcvc.intern_choose.model.TeacherStudent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherStudentServiceTest {

    @Autowired
    private TeacherStudentService teacherStudentService;
    @Test
    void readAll() {
        teacherStudentService.readAll(null).forEach(System.out::println);
    }

    @Test
    void get() {
        System.out.println(teacherStudentService.get(8));
    }

    @Test
    void save() {
        TeacherStudent teacherStudent=new TeacherStudent();
        teacherStudent.setStudentNumber("123123");
        teacherStudent.setTpgId(3);
        System.out.println(teacherStudentService.save(teacherStudent));
    }

    @Test
    void update() {
        TeacherStudent teacherStudent=new TeacherStudent();
        teacherStudent.setId(9);
        teacherStudent.setStudentNumber("1231");
        teacherStudent.setTpgId(3);
        System.out.println(teacherStudentService.update(teacherStudent));
    }

    @Test
    void delete() {
        System.out.println(teacherStudentService.delete(9));
    }
}