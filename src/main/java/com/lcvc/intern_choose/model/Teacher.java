package com.lcvc.intern_choose.model;

public class Teacher {
    private String teacherNumber;
    private String name;
    private String password;
    private Integer professionalId;//专业群ID
    private Integer studentQuantity;//学生数量
    private Professional professional;//专业群

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
