package com.lcvc.intern_choose.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class Student {
    @NotNull(message = "学号不能为空")
    private String studentNumber;//学生主键
    @NotNull(message = "姓名不能为空")
    @Length(min = 2,max = 10 ,message = "name长度要求2到10之间。")
    private String password;
    private String name;//学生名字
    @NotNull(message = "班级ID不能为空")
    private Integer classId; //班级ID，可以通过班级ID查询到所在的专业群
    private Classes classes; //班级对象


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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
