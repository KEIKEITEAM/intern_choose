package com.lcvc.intern_choose.dao;

import com.lcvc.intern_choose.model.TeacherStudent;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherStudentDao extends IBaseDao<TeacherStudent> {
    //根据studentNumber查询
    TeacherStudent getByStudentNumber(String studentNumber);

}
