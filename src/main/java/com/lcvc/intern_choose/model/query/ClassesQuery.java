package com.lcvc.intern_choose.model.query;

import com.lcvc.intern_choose.model.Classes;

import java.util.List;

/**
 * @Author KEI
 * 2020/6/9 11:13
 */
public class ClassesQuery extends Classes {

    /**
     * 根据majorIds查询班级
     */
    private List<Integer> majorIds;

    public List<Integer> getMajorIds() {
        return majorIds;
    }

    public void setMajorIds(List<Integer> majorIds) {
        this.majorIds = majorIds;
    }
}
