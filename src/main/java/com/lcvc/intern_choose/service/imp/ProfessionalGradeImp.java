package com.lcvc.intern_choose.service.imp;

import com.lcvc.intern_choose.dao.GradesDao;
import com.lcvc.intern_choose.dao.ProfessionalDao;
import com.lcvc.intern_choose.dao.ProfessionalGradeDao;
import com.lcvc.intern_choose.model.ProfessionalGrade;
import com.lcvc.intern_choose.model.base.PageObject;
import com.lcvc.intern_choose.model.exception.MyServiceException;
import com.lcvc.intern_choose.model.query.ProfessionalGradeQuery;
import com.lcvc.intern_choose.service.ProfessionalGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public PageObject query(Integer page, Integer limit, ProfessionalGradeQuery professionalGradeQuery) {
        PageObject pageObject = new PageObject(limit,page,professionalGradeDao.querySize(professionalGradeQuery));
        pageObject.setList(professionalGradeDao.query(pageObject.getOffset(),pageObject.getLimit(),professionalGradeQuery));
        return pageObject;
    }


    @Override
    public ProfessionalGrade get(Integer id) {

        return professionalGradeDao.get(id);
    }

    @Override
    public Boolean save(ProfessionalGrade professionalGrade) {
        //根据professionalId和gradeId判断是否存在数据，保证数据唯一
        ProfessionalGradeQuery professionalGradeQuery=new ProfessionalGradeQuery();
        professionalGradeQuery.setGradeId(professionalGrade.getGradeId());
        professionalGradeQuery.setProfessionalId(professionalGrade.getProfessionalId());
        int sum=professionalGradeDao.querySize(professionalGradeQuery);
        if (sum==1){
            throw new MyServiceException("您已经添加过相同的记录，请勿重复添加");
        }else if (sum>1){
            throw new MyServiceException("数据有误,请联系管理员");
        }

        //判断professional是否存在
        if (professionalDao.get(professionalGrade.getProfessionalId()) == null) {
            throw new MyServiceException("professionalId数据有误，请重新提交");
        }
        //判断grades是否存在
        if (gradesDao.get(professionalGrade.getGradeId()) == null) {
            throw new MyServiceException("gradeId数据有误，请重新提交");
        }

        //判断开放权限的时间，结束时间要大于开始时间
        if (professionalGrade.getEndTime().compareTo(professionalGrade.getStartTime())<0){
            throw new MyServiceException("权限开放时间有误，请重新提交");
        }
        //创建时间
        professionalGrade.setCreatTime(new Date());
        int k = professionalGradeDao.save(professionalGrade);
        return k > 0;
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
        //判断开放权限的时间，结束时间要大于开始时间
        if (professionalGrade.getEndTime().compareTo(professionalGrade.getStartTime())<0){
            throw new MyServiceException("权限开放时间有误，请重新提交");
        }

        int k = professionalGradeDao.update(professionalGrade);
        return k > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        int k = professionalGradeDao.delete(id);

        return k > 0;
    }
}
