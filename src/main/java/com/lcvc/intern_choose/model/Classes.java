package com.lcvc.intern_choose.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Classes {
    private Integer id;
    @NotEmpty(message = "name不能为空")
    @Length(min = 1, max = 10, message = "name长度要求1到10之间。")
    private String name;
    @NotNull(message = "majorId不能为空")
    private Integer majorId;
    @NotNull(message = "gradeId不能为空")
    private Integer gradeId;
    //专业对象
    private Major major;
    //年级对象
    private Grades grades;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMajorId() {
        return majorId;
    }

    public void setMajorId(Integer majorId) {
        this.majorId = majorId;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public Grades getGrades() {
        return grades;
    }

    public void setGrades(Grades grades) {
        this.grades = grades;
    }


}
