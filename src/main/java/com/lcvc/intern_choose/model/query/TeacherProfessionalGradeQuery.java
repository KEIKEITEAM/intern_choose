package com.lcvc.intern_choose.model.query;

import com.lcvc.intern_choose.model.TeacherProfessionalGrade;

/**
 * @author 张峰
 */
public class TeacherProfessionalGradeQuery extends TeacherProfessionalGrade {

    /**
     * 子查询，如果为真，则查询根据teacher_professional_grade.id查询没有够实习学生的老师
     */
    private Boolean lessThanStudentQuantity;

    public Boolean getLessThanStudentQuantity() {
        return lessThanStudentQuantity;
    }

    public void setLessThanStudentQuantity(Boolean lessThanStudentQuantity) {
        this.lessThanStudentQuantity = lessThanStudentQuantity;
    }
}
