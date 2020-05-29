package com.lcvc.intern_choose.service;

import com.lcvc.intern_choose.util.SHA;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TeacherServiceTests {
    @Autowired
    private TeacherService teacherService;
    @Test
    void login(){
        System.out.println(teacherService.login("123", SHA.getResult("123456")));
    }

    @Test
    void get(){
        System.out.println(teacherService.get("123"));
    }

}
