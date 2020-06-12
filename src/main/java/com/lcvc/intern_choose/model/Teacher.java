package com.lcvc.intern_choose.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author 张峰
 */
public class Teacher{
    /**
     * 教师工号
     */
    @NotNull(message = "教师工号不能为空")
    private String teacherNumber;
    /**
     * 教师姓名
     */
    @NotNull(message = "教师姓名不能为空")
    @Length(min = 2,max = 10,message = "教师姓名长度要求2到10之间")
    private String name;
    /**
     * 专业群ID
     */
    @NotNull(message = "professionalId不能为空")
    private Integer professionalId;

    /**
     * 密码
     */
    private String password;

    /**
     * 电话号码
     */
    private String tel;

    /**
     * QQ号码
     */
    private String qq;
    /**
     * 学生数量
     */
    @NotNull(message = "studentQuantity不能为空")
    private Integer studentQuantity;
    /**
     * 专业群
     */
    private Professional professional;


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
