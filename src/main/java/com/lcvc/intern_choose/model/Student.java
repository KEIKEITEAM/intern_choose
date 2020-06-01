package com.lcvc.intern_choose.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Student {
    private String studentNumber;//学生主键
    private String name;//学生名字
    @JsonIgnore//该注解是请求返回json数据指定字段不返回
    private String password;//密码
    private Integer classId;//班级ID，可以通过班级ID查询到所在的专业群
    private Classes classes;//班级对象

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }
}
