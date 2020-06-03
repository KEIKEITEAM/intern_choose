package com.lcvc.intern_choose.service;

import com.lcvc.intern_choose.model.TeacherStudent;

import java.util.List;

/**
 * @author liang
 */
public interface TeacherStudentService {

    List<TeacherStudent> readAll(Object object);

    TeacherStudent get(Integer id);

    Boolean save(TeacherStudent teacherStudent);

    Boolean update(TeacherStudent teacherStudent);

    Boolean delete(Integer id);
}
