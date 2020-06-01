package com.lcvc.intern_choose.model.query;

import com.lcvc.intern_choose.model.ProfessionalGrade;

public class ProfessionalGradeQuery extends ProfessionalGrade {
    //给ProfessionalGrade的open一个判断的标签，因为Boolean类型默认值是false，
    // 需多加个判断的标签，availableOpen为true时启用open
    private Boolean availableOpen;

    public Boolean getAvailableOpen() {
        return availableOpen;
    }

    public void setAvailableOpen(Boolean availableOpen) {
        this.availableOpen = availableOpen;
    }


}
