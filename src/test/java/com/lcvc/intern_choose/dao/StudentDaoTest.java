package com.lcvc.intern_choose.dao;

import com.lcvc.intern_choose.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentDaoTest {

    @Autowired
    private StudentDao studentDao;
    @Test
    void readAll() {
        for (Student student : studentDao.readAll()) {
            System.out.println(student);
        }
    }

    @Test
    void get() {
        System.out.println(studentDao.get(1));
    }

    @Test
    void save() {
        Student student = new Student();
        student.setStudentNumber("2");
        student.setClassId(1);
        student.setName("liang");
        student.setPassword("123456");
        studentDao.save(student);
    }

    @Test
    void update() {
        Student student = new Student();
        student.setStudentNumber("1");
        student.setClassId(1);
        student.setName("liandfg");
        student.setPassword("123456");
        System.out.println(studentDao.update(student));
    }

    @Test
    void delete() {
        studentDao.delete("1");
    }
}