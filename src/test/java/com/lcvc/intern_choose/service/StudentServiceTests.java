package com.lcvc.intern_choose.service;

import com.lcvc.intern_choose.model.Student;
import com.lcvc.intern_choose.model.query.StudentQuery;
import com.lcvc.intern_choose.util.SHA;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        List<Student> list=studentService.getNotChooseStudent(20,20,null).getList();
        for (Student student:list) {
            System.out.println(student.getStudentNumber());
        }
    }

    @Test
    void testStduentQuery(){
        StudentQuery studentQuery=new StudentQuery();
        studentQuery.setProfessionalQuery(1);
        System.out.println(studentService.query(null,null,null));
    }

    @Test
    void testGetOpenStudent(){
        System.out.println(studentService.getOpenStudent(1,10));
    }

    @Test
    void testtset1(){
        List<Student> listName=studentService.readAll(null);
        Random r=new Random();
        while(listName.size()>0)
        {
            int i=r.nextInt(listName.size());
            // String str=;
            System.out.print(listName.get(i).getStudentNumber()+" ");
            listName.remove(i);
        }
    }

    /**
     * 2009010034 2006010016 2009010108 2007010009 2006010149 2007010004 2006020058 2006010006 2007010048 2007010006 2018010121 2009020020
     * 2006010047 2006020059 2007010002 2009020020 2009010034 2016010005 2007010009 2006010015 2007010048 2006010027 2006010022 2006010006
     * 2009000062 2006010018 2006010007 2016010005 2006010005 2009010034 2006010149 2018010244 2007010002 2006010028 2018010121 2006010017
     * 2006010027 2007010006 2006020034 2006010017 2006010047 2007010004 2009010095 2006010014 2009000062 2016010005 2018010234 2007010048
     */
    @Test
    void testtest(){
        String[] name=new String[]{"1","2","3","4","5","6"};//此处替换bai为你自己的字符du串
        List<String> listName=new ArrayList<String>();
        for(String s:name)
            listName.add(s);
        Random r=new Random();
        while(listName.size()>0)
        {
            int i=r.nextInt(listName.size());
            // String str=;
            System.out.print(listName.get(i)+" ");
            listName.remove(i);
        }
    }
    /**
     * 2 5 1 4 3 6
     * 4 3 2 5 1 6
     * 2 5 4 1 3 6
     * 4 2 5 3 6 1
     */
}
