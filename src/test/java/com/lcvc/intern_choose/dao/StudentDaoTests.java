package com.lcvc.intern_choose.dao;

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

}
