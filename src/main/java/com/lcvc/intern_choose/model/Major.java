package com.lcvc.intern_choose.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class Major {
    private Integer id;//专业ID
    @NotNull(message = "name不能够为空")
    @Length(min = 2,max = 10,message = "name长度要求2到10之间")
    private String name;//专业名称
    @NotNull(message = "professionalId不能够为空")
    private Integer professionalId;//专业群ID外键
    private Professional professional;//专业群对象

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

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }
}
