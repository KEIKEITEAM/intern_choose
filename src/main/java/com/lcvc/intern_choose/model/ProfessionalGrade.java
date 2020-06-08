package com.lcvc.intern_choose.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class ProfessionalGrade {
    //专业群年级关系表
    private Integer Id;//id
    @NotNull(message = "professionalId不能为空")
    private Integer professionalId;//专业群ID外键
    @NotNull(message = "gradeId不能为空")
    private Integer gradeId;//年级表ID外键
    @NotNull(message = "open不能为空")
    private boolean open;//是否开放选择实习老师的权限
    @NotNull(message = "startTime不能为空")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date startTime;//开放选择权限的开始时间
    //开放选择权限的结束时间
    @NotNull(message = "endTime不能为空")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date endTime;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date creatTime;
    //专业群对象
    private Professional professional;
    //年级对象
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
