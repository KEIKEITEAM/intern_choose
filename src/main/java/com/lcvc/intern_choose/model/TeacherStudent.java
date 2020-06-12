package com.lcvc.intern_choose.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class TeacherStudent {
    /**
     *  学生和专业群年级开放权限的教师关系表
     */
    private Integer id;
    /**
     * 学号
     */
    @NotNull(message = "学号不能为空")
    private String studentNumber;
    /**
     * 专业群年级开放权限的教师关系表的ID *TeacherProfessioanlGrade简写tpg
     */
    @NotNull(message = "tpgId不能为空")
    private Integer tpgId;

    /**
     *创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date creatTime;
    /**
     * 学生对象
     */
    private Student student;
    /**
     * 教师专业群年级关系对象
     */
    private TeacherProfessionalGrade teacherProfessionalGrade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public Integer getTpgId() {
        return tpgId;
    }

    public void setTpgId(Integer tpgId) {
        this.tpgId = tpgId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public TeacherProfessionalGrade getTeacherProfessionalGrade() {
        return teacherProfessionalGrade;
    }

    public void setTeacherProfessionalGrade(TeacherProfessionalGrade teacherProfessionalGrade) {
        this.teacherProfessionalGrade = teacherProfessionalGrade;
    }
}
