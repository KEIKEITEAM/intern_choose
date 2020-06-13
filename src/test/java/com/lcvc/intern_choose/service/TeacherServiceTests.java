package com.lcvc.intern_choose.service;

import com.lcvc.intern_choose.model.Teacher;
import com.lcvc.intern_choose.util.SHA;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
        teacher.setTeacherNumber("12323");
        teacher.setProfessionalId(1);
        teacher.setName("张三");
        teacher.setStudentQuantity(10);
        teacher.setPassword("123123123");
        teacher.setQq("123123123");
        teacher.setTel("123123");
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
        teacher.setTeacherNumber("12323");
        teacher.setProfessionalId(2);
        teacher.setName("张三223");
        teacher.setPassword("qweqwe");
        teacher.setQq("qweqwe");
        teacher.setTel("qweqwe");
        System.out.println(teacherService.update(teacher));
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
        List<Teacher>list=teacherService.readAll();

        for (int i = 0; i < list.size(); i++) {
            String id=list.get(i).getTeacherNumber();
            String password=SHA.getResult(list.get(i).getTeacherNumber());
            Teacher teacher=new Teacher();
            teacher.setTeacherNumber(id);
            teacher.setPassword(password);
            System.out.println(teacherService.update(teacher));
        }
    }


}
