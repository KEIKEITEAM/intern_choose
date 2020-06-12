package com.lcvc.intern_choose.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class TeacherProfessionalGrade {
    private Integer id;
    /**
     * 教师Id
     */
    @NotNull(message = "教师学号不能为空")
    private String teacherNumber;
    /**
     * 专业群年级关系表ID外键
     */
    @NotNull(message = "professionalGradeId不能为空")
    private Integer professionalGradeId;
    /**
     * 实习学生最大选择数量
     */
    @NotNull(message = "实习生数量不能为空")
    private Integer studentQuantity;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date creatTime;
    /**
     * 教师对象
     */
    private Teacher teacher;
    /**
     * 专业群年级对象
     */
    private ProfessionalGrade professionalGrade;


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

    public ProfessionalGrade getProfessionalGrade() {
        return professionalGrade;
    }

    public void setProfessionalGrade(ProfessionalGrade professionalGrade) {
        this.professionalGrade = professionalGrade;
    }
}
