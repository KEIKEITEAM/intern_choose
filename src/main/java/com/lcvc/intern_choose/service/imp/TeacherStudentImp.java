package com.lcvc.intern_choose.service.imp;

import com.lcvc.intern_choose.dao.TeacherProfessionalGradeDao;
import com.lcvc.intern_choose.dao.TeacherStudentDao;
import com.lcvc.intern_choose.model.TeacherStudent;
import com.lcvc.intern_choose.model.base.PageObject;
import com.lcvc.intern_choose.model.exception.MyServiceException;
import com.lcvc.intern_choose.model.query.TeacherStudentQuery;
import com.lcvc.intern_choose.service.TeacherStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherStudentImp implements TeacherStudentService {
    @Autowired
    private TeacherStudentDao teacherStudentDao;
    @Autowired
    private TeacherProfessionalGradeDao teacherProfessionalGradeDao;

    @Override
    public List<TeacherStudent> readAll(Object object) {
        return teacherStudentDao.readAll(null);
    }

    @Override
    public TeacherStudent get(Integer id) {
        return teacherStudentDao.get(id);
    }

    @Override
    public Boolean save(TeacherStudent teacherStudent) {
        /**
         * tpgId是专业群年级开放权限的教师关系表的ID *TeacherProfessioanlGrade简写tpg
         */

        if (teacherProfessionalGradeDao.get(teacherStudent.getTpgId()) == null) {
            throw new MyServiceException("tpgId输入有误，请重新输入");
        }

        int k = teacherStudentDao.save(teacherStudent);
        return k > 0;
    }

    @Override
    public Boolean update(TeacherStudent teacherStudent) {
        /**
         * tpgId是专业群年级开放权限的教师关系表的ID *TeacherProfessioanlGrade简写tpg
         */

        if (teacherProfessionalGradeDao.get(teacherStudent.getTpgId()) == null) {
            throw new MyServiceException("tpgId输入有误，请重新输入");
        }

        int k = teacherStudentDao.update(teacherStudent);
        return k > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        int k = teacherStudentDao.delete(id);
        return k > 0 ;
    }

    @Override
    public PageObject query(Integer page, Integer limit, TeacherStudentQuery teacherStudentQuery) {
        PageObject pageObject = new PageObject(limit,page,teacherStudentDao.querySize(teacherStudentQuery));
        pageObject.setList(teacherStudentDao.query(pageObject.getOffset(),pageObject.getLimit(),teacherStudentQuery));
        return pageObject;
    }
}
