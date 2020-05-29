package com.lcvc.intern_choose.service;

import com.lcvc.intern_choose.model.Teacher;
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
        System.out.println(teacherService.get("1"));
    }


    /**
     * liang
     * 老师添加方法测试
     * 2020年5月29日23:36
     */
    @Test
    void  save(){
        Teacher teacher = new Teacher();
        teacher.setTeacherNumber("1");
        teacher.setProfessionalId(1);
        teacher.setPassword("1111");
        teacher.setName("张三");
        System.out.println(teacherService.save(teacher));
    }

    /**
     * liang
     * 老师修改方法测试
     * 2020年5月29日23:36
     */
    @Test
    void  update(){
        Teacher teacher = new Teacher();
        teacher.setTeacherNumber("1");
        teacher.setProfessionalId(1);
        teacher.setPassword("1111");
        teacher.setName("张三1");
        System.out.println(teacherService.save(teacher));
    }

    /**
     * liang
     * 老师删除方法测试
     * 2020年5月29日23:36
     */
    @Test
    void  delete(){
        System.out.println(teacherService.delete("1"));
    }

    /**
     * liang
     * 老师查询方法测试
     * 2020年5月29日22：38
     */
    @Test
    void  realAll(){
        System.out.println(teacherService.readAll());
    }
}
