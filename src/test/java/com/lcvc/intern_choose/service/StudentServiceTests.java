package com.lcvc.intern_choose.service;

import com.lcvc.intern_choose.model.Student;
import com.lcvc.intern_choose.util.SHA;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;

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
        System.out.println(studentService.get("1"));
    }

    /**
     * liang
     * 学生添加方法测试
     * 2020年5月29日23:02
     */
    @Test
    void  save(){
        Student student = new Student();
        student.setName("hh");
        student.setPassword("121");
        student.setClassId(1);
        student.setStudentNumber("33434");
        student.setQq("123123");
        student.setTel("123123123");
        System.out.println(studentService.save(student));
    }

    /**
     * liang
     * 学生修改方法测试
     * 2020年5月29日23:02
     */
    @Test
    void  update(){
        Student student = new Student();
        student.setName("123");
        student.setPassword("123123123123");
        student.setClassId(2);
        student.setStudentNumber("33434");
        student.setQq("qweqwe");
        student.setTel("qweqwe");
        System.out.println(studentService.update(student));
    }

    /**
     * liang
     * 学生删除方法测试
     * 2020年5月29日23:02
     */
    @Test
    void  delete(){
        System.out.println(studentService.delete("1"));
    }

    /**
     * liang
     * 学生查询方法测试
     * 2020年5月29日22：38
     */
    @Test
    void  realAll(){
        System.out.println(studentService.readAll(null));
    }

    @Test
    void choose() throws ParseException {
        //123
        studentService.choose("123","2006000002");

    }

    @Test
    void test(){
        System.out.println(studentService.getAvailableTeacher(1));
    }
}
