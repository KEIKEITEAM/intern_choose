package com.lcvc.intern_choose.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class TeacherProfessionalGrade {
    private Integer id;
    @NotNull
    private String teacherNumber;
    @NotNull
    private Integer professionalGradeId;//专业群年级关系表ID外键
    @NotNull
    private Integer studentQuantity;//实习学生最大选择数量
    /*
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date creatTime;

    private Teacher teacher;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeacherNumber() {
        return teacherNumber;
    }

    public void setTeacherNumber(String teacherNumber) {
        this.teacherNumber = teacherNumber;
    }

    public Integer getProfessionalGradeId() {
        return professionalGradeId;
    }

    public void setProfessionalGradeId(Integer professionalGradeId) {
        this.professionalGradeId = professionalGradeId;
    }

    public Integer getStudentQuantity() {
        return studentQuantity;
    }

    public void setStudentQuantity(Integer studentQuantity) {
        this.studentQuantity = studentQuantity;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }
}
