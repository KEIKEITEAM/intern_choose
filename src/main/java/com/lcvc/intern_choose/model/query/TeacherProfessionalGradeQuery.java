package com.lcvc.intern_choose.model.query;

import com.lcvc.intern_choose.model.TeacherProfessionalGrade;

/**
 * @author 张峰
 */
public class TeacherProfessionalGradeQuery extends TeacherProfessionalGrade {

    /**
     * 子查询，如果为真，则查询根据teacher_professional_grade.id
     * 查询子表teacherStudent表中 没有够实习学生的老师
     */
    private Boolean lessThanStudentQuantity;

    /**
     * 如果name!=null
     *子查询,名字模糊查询,根据名字模糊查询teacher表-
     */
    private String name;

    /**
     * 如果professionalId!=null
     * 子查询,根据professionalId查询teacher表
     */
    private Integer professionalId;

    public Boolean getLessThanStudentQuantity() {
        return lessThanStudentQuantity;
    }

    public void setLessThanStudentQuantity(Boolean lessThanStudentQuantity) {
        this.lessThanStudentQuantity = lessThanStudentQuantity;
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
}
