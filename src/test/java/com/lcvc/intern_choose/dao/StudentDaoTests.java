package com.lcvc.intern_choose.dao;

import com.lcvc.intern_choose.model.Student;
import com.lcvc.intern_choose.model.query.StudentQuery;
import com.lcvc.intern_choose.util.SHA;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    void realAll(){
        List<Student>list=studentDao.readAll(null);
        for (int i = 0; i < list.size(); i++) {
                String s=list.get(i).getPassword().substring(12,18);
                System.out.println(s+" "+list.get(i).getStudentNumber());
                Student student=new Student();
                student.setPassword(SHA.getResult(s));
                student.setStudentNumber(list.get(i).getStudentNumber());
                studentDao.update(student);
        }

    }



    /**
     * liang
     * 学生添加方法测试
     * 2020年5月29日19:25
     */
    @Test
    void save() {
        Student student = new Student();
        student.setName("hh");
        student.setPassword("121");
        student.setClassId(1);
        student.setStudentNumber("33434");
        student.setQq("123123");
        student.setTel("123123123");
        studentDao.save(student);
    }

    /**
     * liang
     * 学生查询方法测试
     * 2020年5月29日19:25
     */
    @Test
    void readAll() {
        StudentQuery studentQuery=new StudentQuery();
        studentQuery.setName("本");
        for (Student student : studentDao.readAll(studentQuery)) {
            System.out.println(student.getName()+"————");
        }
    }

    /**
     * liang
     * 学生修改方法测试
     * 2020年5月29日19:25
     */
    @Test
    void update() {
        Student student = new Student();
        student.setPassword("11");
        student.setClassId(2);
        student.setStudentNumber("33434");
        student.setName("klf");
        student.setTel("189898989");
        student.setQq("123123123");
        System.out.println(studentDao.update(student));
    }

    /**
     * liang
     * 学生删除方法测试
     * 2020年5月29日19:25
     */
    @Test
    void delete() {
        System.out.println(studentDao.delete("1"));
    }

    /**
     *
     */
    @Test
    void test(){
        StudentQuery studentQuery=new StudentQuery();
//        List<String>  list=new ArrayList<>();
//        list.add("184023102");
//        list.add("184023095");
//        list.add("184023092");
        String [] arr={"184023102","184023095","184023092"};
        studentQuery.setStudentNumbers(arr);
       System.out.println(studentDao.querySize(studentQuery));
    }

    @Test
    void getAll(){
        StudentQuery studentQuery=new StudentQuery();
        //,184023095,184023092
        String [] s={"184023102","184023095","184023092"};
        //studentQuery.setStudentNumber("(184023102)");
        //studentQuery.setClassId(1);
        studentQuery.setStudentNumbers(s);
        //System.out.println(studentDao.readAll(studentQuery));
    }

    @Test
    void getByClassIds(){
        List<Integer> ids= new ArrayList<>();
        ids.add(1);
        ids.add(2);
        StudentQuery studentQuery=new StudentQuery();
        studentQuery.setClassIds(ids);
        System.out.println(studentDao.querySize(studentQuery));
    }

    @Test
    void getByMajorIds(){
        List<Integer> ids= new ArrayList<>();
        StudentQuery studentQuery=new StudentQuery();
        studentQuery.setProfessionalQuery(1);
        System.out.println(studentDao.querySize(studentQuery));
    }
}
