package com.lcvc.intern_choose.dao;

import com.lcvc.intern_choose.util.SHA;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TeacherDaoTests {
    @Autowired
    private TeacherDao teacherDao;
    @Test
    void login(){
        System.out.println(teacherDao.login("123", SHA.getResult("123456")));
    }

    @Test
    void get(){
        System.out.println(teacherDao.get("123"));
    }

}
