package com.lcvc.intern_choose.model;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class ProfessionalGrade {
    //专业群年级关系表
    /**
     * id
     */
    private Integer Id;
    /**
     * 专业群ID外键
     */
    @NotNull(message = "professionalId不能为空")
    private Integer professionalId;
    /**
     * 年级表ID外键
     */
    @NotNull(message = "gradeId不能为空")
    private Integer gradeId;
    /**
     * 是否开放选择实习老师的权限
     */
    @NotNull(message = "open不能为空")
    private boolean open;
    /**
     * 开放选择权限的开始时间
     */
    @NotNull(message = "startTime不能为空")
    private Date startTime;
    /**
     * 开放选择权限的结束时间
     */
    @NotNull(message = "endTime不能为空")
    private Date endTime;
    /**
     * 创建时间
     */
    private Date creatTime;
    /**
     * 专业群对象
     */
    private Professional professional;
    /**
     *年级对象
     */
    private Grades grades;

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(Integer professionalId) {
        this.professionalId = professionalId;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Grades getGrades() {
        return grades;
    }

    public void setGrades(Grades grades) {
        this.grades = grades;
    }
}
