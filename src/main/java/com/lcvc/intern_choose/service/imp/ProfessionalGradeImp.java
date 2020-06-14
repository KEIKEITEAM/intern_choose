package com.lcvc.intern_choose.service.imp;

import com.lcvc.intern_choose.dao.GradesDao;
import com.lcvc.intern_choose.dao.ProfessionalDao;
import com.lcvc.intern_choose.dao.ProfessionalGradeDao;
import com.lcvc.intern_choose.dao.TeacherProfessionalGradeDao;
import com.lcvc.intern_choose.model.ProfessionalGrade;
import com.lcvc.intern_choose.model.TeacherProfessionalGrade;
import com.lcvc.intern_choose.model.base.PageObject;
import com.lcvc.intern_choose.model.exception.MyServiceException;
import com.lcvc.intern_choose.model.query.ProfessionalGradeQuery;
import com.lcvc.intern_choose.model.query.TeacherProfessionalGradeQuery;
import com.lcvc.intern_choose.service.ProfessionalGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
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
    @Autowired
    private TeacherProfessionalGradeDao teacherProfessionalGradeDao;

    @Override
    public List<ProfessionalGrade> readAll(ProfessionalGradeQuery professionalGradeQuery) {
        return professionalGradeDao.readAll(professionalGradeQuery);
    }

    @Override
    public PageObject query(Integer page, Integer limit, ProfessionalGradeQuery professionalGradeQuery) {
        //打开查询开放条件为真的判断,getAvailableOpen为true时才会打开查询open字段
        if (professionalGradeQuery.getAvailableOpen()!=null){
            if (professionalGradeQuery.getAvailableOpen()){
                professionalGradeQuery.setOpen(professionalGradeQuery.getAvailableOpen());
            }else{
                professionalGradeQuery.setAvailableOpen(true);
                professionalGradeQuery.setOpen(false);
            }
        }
        PageObject pageObject = new PageObject(limit, page, professionalGradeDao.querySize(professionalGradeQuery));
        pageObject.setList(professionalGradeDao.query(pageObject.getOffset(), pageObject.getLimit(), professionalGradeQuery));
        return pageObject;
    }


    @Override
    public ProfessionalGrade get(Integer id) {

        return professionalGradeDao.get(id);
    }

    @Override
    public Boolean save(ProfessionalGrade professionalGrade) {
        //根据professionalId和gradeId判断是否存在数据，保证数据唯一
        ProfessionalGradeQuery professionalGradeQuery = new ProfessionalGradeQuery();
        professionalGradeQuery.setGradeId(professionalGrade.getGradeId());
        professionalGradeQuery.setProfessionalId(professionalGrade.getProfessionalId());
        int sum = professionalGradeDao.querySize(professionalGradeQuery);
        if (sum == 1) {
            throw new MyServiceException("您已经添加过相同的数据，请勿重复添加");
        } else if (sum > 1) {
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
        if (professionalGrade.getEndTime().compareTo(professionalGrade.getStartTime()) < 0) {
            throw new MyServiceException("权限开放时间有误，请重新提交");
        }
        //创建时间
        professionalGrade.setCreatTime(new Date());
        int k = professionalGradeDao.save(professionalGrade);
        return k > 0;
    }

    @Override
    public Boolean update(ProfessionalGrade professionalGrade) throws ParseException {
        //判断professional是否存在
        if (professionalGrade.getProfessionalId() != null) {
            if (professionalDao.get(professionalGrade.getProfessionalId()) == null) {
                throw new MyServiceException("professionalId数据有误，请重新提交");
            }
        }

        //判断grades是否存在
        if (professionalGrade.getGradeId() != null) {
            if (gradesDao.get(professionalGrade.getGradeId()) == null) {
                throw new MyServiceException("gradeId数据有误，请重新提交");
            }
        }
        //判断开放权限的时间，结束时间要大于开始时间
        if (professionalGrade.getEndTime() != null && professionalGrade.getStartTime() != null) {
            if (professionalGrade.getEndTime().compareTo(professionalGrade.getStartTime()) < 0) {
                throw new MyServiceException("权限开放时间有误，请重新提交");
            }
        }
        int k = professionalGradeDao.update(professionalGrade);
        return k > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        int k = professionalGradeDao.delete(id);

        return k > 0;
    }

    @Override
    public List<ProfessionalGrade> getProfessionalGradeByTeacherNumber(String teacherNumber) {
        //根据teacherNumber获取teacherProfessionalGradeList
        TeacherProfessionalGradeQuery teacherProfessionalGradeQuery = new TeacherProfessionalGradeQuery();
        teacherProfessionalGradeQuery.setTeacherNumber(teacherNumber);
        List<TeacherProfessionalGrade> teacherProfessionalGradeList = teacherProfessionalGradeDao.readAll(teacherProfessionalGradeQuery);

        //创建professionalGrad集合
        List<ProfessionalGrade> professionalGradeList = new ArrayList<>();
        //将 teacherProfessionalGradeList.
        for (int i = 0; i < teacherProfessionalGradeList.size(); i++) {
            int id = teacherProfessionalGradeList.get(i).getProfessionalGrade().getId();
            ProfessionalGrade professionalGrade = professionalGradeDao.get(id);
            if (professionalGrade != null) {
                professionalGradeList.add(professionalGrade);
            }
        }
        return professionalGradeList.size() != 0 ? professionalGradeList : null;
    }
}
