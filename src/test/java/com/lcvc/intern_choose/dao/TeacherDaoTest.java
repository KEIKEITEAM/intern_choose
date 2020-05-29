package com.lcvc.intern_choose.dao;

import com.lcvc.intern_choose.model.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherDaoTest {
    @Autowired
    private TeacherDao teacherDao;

    @Test
    void readAll() {
        for (Teacher teacher : teacherDao.readAll()) {
            System.out.println(teacher);
        }
    }

    @Test
    void get() {
        System.out.println(teacherDao.get("1"));
    }

    @Test
    void save() {
        Teacher teacher = new Teacher();
        teacher.setName("1513");
        teacher.setPassword("123456");
        teacher.setProfessionalId(2);
        teacher.setTeacherNumber("1");
        System.out.println(teacherDao.save(teacher));
    }

    @Test
    void update() {
        Teacher teacher = new Teacher();
        teacher.setName("1513");
        teacher.setPassword("123456");
        teacher.setProfessionalId(1);
        teacher.setTeacherNumber("12323");
        System.out.println(teacherDao.update(teacher));
    }

    @Test
    void delete() {
        System.out.println(teacherDao.delete("1"));
    }
}