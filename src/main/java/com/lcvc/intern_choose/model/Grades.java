package com.lcvc.intern_choose.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @author 张峰
 */
public class Grades {
    private Integer id;
    @NotNull(message = "name不能为空")
    @Length(min = 2,max = 10,message = "name长度要求2到10之间")
    private String name;

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

}
