package com.lcvc.intern_choose.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class Major {
    /**
     * 专业ID
     */
    private Integer id;
    /**
     * 名称
     */
    @NotNull(message = "name不能够为空")
    @Length(min = 2,max = 10,message = "name长度要求2到10之间")
    /**
     *专业名称
     */
    private String name;
    @NotNull(message = "professionalId不能够为空")
    /**
     * 专业群ID外键
     */
    private Integer professionalId;
    @NotNull(message = "open不能为空")
    /**
     * 是否开放选择权限
     */
    private Boolean open;
    /**
     * 专业群对象
     */
    private Professional professional;


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

    public Integer getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(Integer professionalId) {
        this.professionalId = professionalId;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }
}
