package com.lcvc.intern_choose.service;

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

}
