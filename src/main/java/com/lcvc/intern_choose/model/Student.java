package com.lcvc.intern_choose.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class Student {
    /**
     * 学生主键
     */
    @NotNull(message = "学号不能为空")
    private String studentNumber;

    /**
     * 密码
     */
    private String password;

    /**
     * 学生名字
     */
    @NotNull(message = "姓名不能为空")
    @Length(min = 2,max = 10,message = "姓名长度要求2到10之间")
    private String name;

    /**
     * 电话号码
     */
    private String tel;

    /**
     * QQ号码
     */
    private String qq;

    /**
     * 班级ID，可以通过班级ID查询到所在的专业群
     */
    @NotNull(message = "班级ID不能为空")
    private Integer classId;
    /**
     * 班级对象
     */
    private Classes classes;


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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
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
