package com.lcvc.intern_choose.model.query;

import com.lcvc.intern_choose.model.Major;

import java.util.List;

/**
 * @Author KEI
 * 2020/6/9 11:17
 */
public class MajorQuery extends Major {
    /**
     * 是否打开open查询字段，默认不打开
     */
    private Boolean availableOpen;

    /**
     * 根据professionalIds集合查询major集合
     */
    private List<Integer> professionalIds;


    public Boolean getAvailableOpen() {
        return availableOpen;
    }

    public void setAvailableOpen(Boolean availableOpen) {
        this.availableOpen = availableOpen;
    }

    public List<Integer> getProfessionalIds() {
        return professionalIds;
    }

    public void setProfessionalIds(List<Integer> professionalIds) {
        this.professionalIds = professionalIds;
    }
}
