package com.lcvc.intern_choose.service.imp;

import com.lcvc.intern_choose.dao.ProfessionalGradeDao;
import com.lcvc.intern_choose.dao.TeacherDao;
import com.lcvc.intern_choose.dao.TeacherProfessionalGradeDao;
import com.lcvc.intern_choose.model.TeacherProfessionalGrade;
import com.lcvc.intern_choose.model.base.PageObject;
import com.lcvc.intern_choose.model.exception.MyServiceException;
import com.lcvc.intern_choose.model.query.TeacherProfessionalGradeQuery;
import com.lcvc.intern_choose.service.TeacherProfessionalGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author liang
 */
@Service
public class TeacherProfessionalGradeImp implements TeacherProfessionalGradeService {
    @Autowired
    private TeacherProfessionalGradeDao teacherProfessionalGradeDao;
    @Autowired
    private ProfessionalGradeDao professionalGradeDao;
    @Autowired
    private TeacherDao teacherDao;

    @Override
    public List<TeacherProfessionalGrade> readAll(Object object) {
        return teacherProfessionalGradeDao.readAll(null);
    }

    @Override
    public TeacherProfessionalGrade get(Integer id) {
        return teacherProfessionalGradeDao.get(id);
    }

    @Override
    public Boolean save(TeacherProfessionalGrade teacherProfessionalGrade) {
        //判断教师书否存在
        if(teacherDao.get(teacherProfessionalGrade.getTeacherNumber())==null){
            throw new MyServiceException("teacherNumber数据有误，请重新提交");
        }
        //判断专业群是否存在
        if (professionalGradeDao.get(teacherProfessionalGrade.getProfessionalGradeId()) == null ){
            throw new MyServiceException("professionalGradeId数据有误，请重新提交");
        }
        teacherProfessionalGrade.setCreatTime(new Date());
        int k = teacherProfessionalGradeDao.save(teacherProfessionalGrade);
        return k>0;
    }

    @Override
    public Boolean update(TeacherProfessionalGrade teacherProfessionalGrade) {
        if (professionalGradeDao.get(teacherProfessionalGrade.getProfessionalGradeId()) == null ){
            throw new MyServiceException("professionalGradeId数据有误，请重新提交");
        }
        int k = teacherProfessionalGradeDao.update(teacherProfessionalGrade);
        return k>0;
    }

    @Override
    public Boolean delete(Integer id) {
        int k = teacherProfessionalGradeDao.delete(id);
        return k>0;
    }

    @Override
    public PageObject query(Integer page, Integer limit, TeacherProfessionalGradeQuery teacherProfessionalGradeQuery) {
        PageObject pageObject = new PageObject(limit,page,teacherProfessionalGradeDao.querySize(teacherProfessionalGradeQuery));
        pageObject.setList(teacherProfessionalGradeDao.query(pageObject.getOffset(),pageObject.getLimit(),teacherProfessionalGradeQuery));
        return pageObject;
    }
}
