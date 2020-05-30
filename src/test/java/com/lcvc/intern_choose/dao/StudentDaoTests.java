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
    void realAll(){
        System.out.println(studentDao.readAll(null));
    }

    @Test
    void delete(){
        System.out.println(studentDao.delete(1));
    }


    @Test
    void save(){
        Student student=new Student();
        student.setClassId(1);
        student.setStudentNumber("123123");
        student.setName("123123");
        student.setPassword("123123");
        System.out.println(studentDao.save(student));
    }

    @Test
    void update(){
        Student student=new Student();
        student.setStudentNumber("123123");
        student.setClassId(12);
        student.setName("ccc");
        student.setPassword("bbb");
        System.out.println(studentDao.update(student));
    }


}
