package com.lcvc.intern_choose.model;

public class TeacherProfessionalGrade {
    private Integer id;
    private String teacherNumber;
    private Integer professionalGradeId;//专业群年级关系表ID外键
    private Integer StudentQuantity;//实习学生最大选择数量
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
        return StudentQuantity;
    }

    public void setStudentQuantity(Integer studentQuantity) {
        StudentQuantity = studentQuantity;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
