package com.lcvc.intern_choose.model.query;

import com.lcvc.intern_choose.model.TeacherStudent;

import java.util.List;

public class TeacherStudentQuery extends TeacherStudent {

    /**
     * 学生名字的模糊查询
     */
    private String studentName;

    /**
     * 根据班级集合查询学生集合
     */
    private List<Integer> classIds;

    /**
     * 以下是各个查询条件
     */
    private Integer majorQuery;

    private Integer gradeQuery;

    private Integer classQuery;

    private Integer professionalQuery;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<Integer> getClassIds() {
        return classIds;
    }

    public void setClassIds(List<Integer> classIds) {
        this.classIds = classIds;
    }

    public Integer getMajorQuery() {
        return majorQuery;
    }

    public void setMajorQuery(Integer majorQuery) {
        this.majorQuery = majorQuery;
    }

    public Integer getGradeQuery() {
        return gradeQuery;
    }

    public void setGradeQuery(Integer gradeQuery) {
        this.gradeQuery = gradeQuery;
    }

    public Integer getClassQuery() {
        return classQuery;
    }

    public void setClassQuery(Integer classQuery) {
        this.classQuery = classQuery;
    }

    public Integer getProfessionalQuery() {
        return professionalQuery;
    }

    public void setProfessionalQuery(Integer professionalQuery) {
        this.professionalQuery = professionalQuery;
    }
}
