package com.lcvc.intern_choose.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class Teacher{
    @NotNull(message = "教师工号不能为空")
    private String teacherNumber;
    @NotNull(message = "教师姓名不能为空")
    @Length(min = 2,max = 10,message = "教师姓名长度要求2到10之间")
    private String name;
    @NotNull(message = "professionalId不能为空")
    private Integer professionalId;//专业群ID

    private String password;

    @NotNull(message = "studentQuantity不能为空")
    private Integer studentQuantity;//学生数量
    private Professional professional;//专业群


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTeacherNumber() {
        return teacherNumber;
    }

    public void setTeacherNumber(String teacherNumber) {
        this.teacherNumber = teacherNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(Integer professionalId) {
        this.professionalId = professionalId;
    }

    public Integer getStudentQuantity() {
        return studentQuantity;
    }

    public void setStudentQuantity(Integer studentQuantity) {
        this.studentQuantity = studentQuantity;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }
}
