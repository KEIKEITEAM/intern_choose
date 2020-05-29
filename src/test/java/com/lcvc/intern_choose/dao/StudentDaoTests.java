package com.lcvc.intern_choose.dao;

import com.lcvc.intern_choose.model.Student;
import com.lcvc.intern_choose.util.SHA;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentDaoTests {
    @Autowired
    private StudentDao studentDao;
    @Test
    void login(){
        System.out.println(studentDao.login("123", SHA.getResult("123456")));
    }

    @Test
    void get(){
        System.out.println(studentDao.get("123"));
    }

    @Test
    void save() {
        Student student = new Student();
        student.setPassword("11");
        student.setClassId(1);
        student.setStudentNumber("1");
        studentDao.save(student);
    }

    @Test
    void readAll() {
        for (Student student : studentDao.readAll()) {
            System.out.println(student);
        }
    }


    @Test
    void update() {
        Student student = new Student();
        student.setPassword("11");
        student.setClassId(1);
        student.setStudentNumber("1");
        student.setName("klf");
        System.out.println(studentDao.update(student));
    }

    @Test
    void delete() {
        System.out.println(studentDao.delete("1"));
    }
}
