package com.lcvc.intern_choose.service.imp;

import com.lcvc.intern_choose.dao.ProfessionalGradeDao;
import com.lcvc.intern_choose.dao.TeacherProfessionalGradeDao;
import com.lcvc.intern_choose.model.TeacherProfessionalGrade;
import com.lcvc.intern_choose.model.exception.MyServiceException;
import com.lcvc.intern_choose.service.TeacherProfessionalGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        if (professionalGradeDao.get(teacherProfessionalGrade.getProfessionalGradeId()) == null ){
            throw new MyServiceException("professionalGradeId数据有误，请重新输入");
        }
        int k = teacherProfessionalGradeDao.save(teacherProfessionalGrade);
        return k>0?true:false;
    }

    @Override
    public Boolean update(TeacherProfessionalGrade teacherProfessionalGrade) {
        if (professionalGradeDao.get(teacherProfessionalGrade.getProfessionalGradeId()) == null ){
            throw new MyServiceException("professionalGradeId数据有误，请重新输入");
        }
        int k = teacherProfessionalGradeDao.update(teacherProfessionalGrade);
        return k>0?true:false;
    }

    @Override
    public Boolean delete(Integer id) {
        int k = teacherProfessionalGradeDao.delete(id);
        return k>0?true:false;
    }
}
