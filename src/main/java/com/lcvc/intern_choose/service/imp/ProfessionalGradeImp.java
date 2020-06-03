package com.lcvc.intern_choose.service.imp;

import com.lcvc.intern_choose.dao.GradesDao;
import com.lcvc.intern_choose.dao.ProfessionalDao;
import com.lcvc.intern_choose.dao.ProfessionalGradeDao;
import com.lcvc.intern_choose.model.Professional;
import com.lcvc.intern_choose.model.ProfessionalGrade;
import com.lcvc.intern_choose.model.exception.MyServiceException;
import com.lcvc.intern_choose.service.ProfessionalGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionalGradeImp implements ProfessionalGradeService {
    @Autowired
    private ProfessionalGradeDao professionalGradeDao;
    @Autowired
    private ProfessionalDao professionalDao;
    @Autowired
    private GradesDao gradesDao;

    @Override
    public List<ProfessionalGrade> readAll(Object object) {
        return professionalGradeDao.readAll(null);
    }

    @Override
    public ProfessionalGrade get(Integer id) {

        return professionalGradeDao.get(id);
    }

    @Override
    public Boolean save(ProfessionalGrade professionalGrade) {
        //判断professional是否存在
        if (professionalDao.get(professionalGrade.getProfessionalId()) == null) {
            throw new MyServiceException("professionalId数据有误，请重新提交");
        }
        //判断grades是否存在
        if (gradesDao.get(professionalGrade.getGradeId()) == null) {
            throw new MyServiceException("gradeId数据有误，请重新提交");
        }

        int k = professionalGradeDao.save(professionalGrade);
        return k > 0 ? true : false;
    }

    @Override
    public Boolean update(ProfessionalGrade professionalGrade) {
        //判断professional是否存在
        if (professionalDao.get(professionalGrade.getProfessionalId()) == null) {
            throw new MyServiceException("professionalId数据有误，请重新提交");
        }
        //判断grades是否存在
        if (gradesDao.get(professionalGrade.getGradeId()) == null) {
            throw new MyServiceException("gradeId数据有误，请重新提交");
        }

        int k = professionalGradeDao.update(professionalGrade);
        return k > 0 ? true : false;
    }

    @Override
    public Boolean delete(Integer id) {
        int k = professionalGradeDao.delete(id);

        return k>0?true:false;
    }
}
