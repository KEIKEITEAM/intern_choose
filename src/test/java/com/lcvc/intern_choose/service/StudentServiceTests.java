package com.lcvc.intern_choose.service;

import com.lcvc.intern_choose.model.Student;
import com.lcvc.intern_choose.util.SHA;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StudentServiceTests {
    @Autowired
    private StudentService studentService;
    @Test
    void login(){
        System.out.println(studentService.login("123", SHA.getResult("123456")));
    }

    @Test
    void get(){
        System.out.println(studentService.get("123"));
    }

    @Test
    void realAll(){
        System.out.println(studentService.readAll(null));
    }

    @Test
    void delete(){
        System.out.println(studentService.delete("1"));
    }


    @Test
    void save(){
        Student student=new Student();
        student.setClassId(1);
        student.setStudentNumber("12311123");
        student.setName("123123");
        student.setPassword("123123");
        System.out.println(studentService.save(student));
    }

    @Test
    void update(){
        Student student=new Student();
        student.setStudentNumber("123123");
        student.setClassId(234234);
        student.setName("asdasd");
        student.setPassword("asdasd");
        System.out.println(studentService.update(student));
    }

}
