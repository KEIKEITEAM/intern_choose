package com.lcvc.intern_choose.model;

import java.util.Date;

public class ProfessionalGrade {
    //专业群年级关系表
    private Integer Id;//id
    private Integer professionalId;//专业群ID外键
    private Integer gradeId;//年级表ID外键
    private boolean open;//是否开放选择实习老师的权限
    private Date startTime;//开放选择权限的开始时间
    private Date endTime;//开放选择权限的结束时间

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
}
