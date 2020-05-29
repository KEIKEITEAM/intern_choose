package com.lcvc.intern_choose.dao;

import com.lcvc.intern_choose.model.Teacher;
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

    @Test
    void readAll() {
        for (Teacher teacher : teacherDao.readAll(null)) {
            System.out.println(teacher);
        }
    }

    @Test
    void save() {
        Teacher teacher = new Teacher();
        teacher.setName("1513");
        teacher.setPassword("123456");
        teacher.setProfessionalId(2);
        teacher.setTeacherNumber("14");
        System.out.println(teacherDao.save(teacher));
    }

    @Test
    void update() {
        Teacher teacher = new Teacher();
        teacher.setName("1513");
        teacher.setPassword("123456");
        teacher.setProfessionalId(1);
        teacher.setTeacherNumber("14");
        System.out.println(teacherDao.update(teacher));
    }

    @Test
    void delete() {
        System.out.println(teacherDao.delete("14"));
    }

}
