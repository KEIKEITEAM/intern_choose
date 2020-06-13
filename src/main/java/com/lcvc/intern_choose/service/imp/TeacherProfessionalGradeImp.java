package com.lcvc.intern_choose.service.imp;

import com.lcvc.intern_choose.dao.ProfessionalGradeDao;
import com.lcvc.intern_choose.dao.TeacherDao;
import com.lcvc.intern_choose.dao.TeacherProfessionalGradeDao;
import com.lcvc.intern_choose.model.ProfessionalGrade;
import com.lcvc.intern_choose.model.Teacher;
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
        //以专业群Id和教师Id查询该条记录是否存在
        TeacherProfessionalGradeQuery teacherProfessionalGradeQuery=new TeacherProfessionalGradeQuery();
        teacherProfessionalGradeQuery.setTeacherNumber(teacherProfessionalGrade.getTeacherNumber());
        teacherProfessionalGradeQuery.setProfessionalGradeId(teacherProfessionalGrade.getProfessionalGradeId());
        int size=teacherProfessionalGradeDao.querySize(teacherProfessionalGradeQuery);
        if (size==1){
            throw new MyServiceException("该条数据已经存在，请勿重复添加");
        }else if (size>1){
            throw new MyServiceException("数据库有误，请联系管理员");
        }

        //判断教师是否存在
        Teacher teacher=teacherDao.get(teacherProfessionalGrade.getTeacherNumber());
        if(teacher==null){
            throw new MyServiceException("teacherNumber数据有误，请重新提交");
        }
        //判断专业群是否存在
        ProfessionalGrade professionalGrade=professionalGradeDao.get(teacherProfessionalGrade.getProfessionalGradeId());
        if ( professionalGrade== null ){
            throw new MyServiceException("professionalGradeId数据有误，请重新提交");
        }
        //判断该ProfessionalGrade的专业群是否是与该老师一致
        if (!teacher.getProfessional().getId().equals(professionalGrade.getProfessional().getId())){
            throw new MyServiceException("该专业群与实习老师的专业群不一致");
        }

        teacherProfessionalGrade.setCreatTime(new Date());
        int k = teacherProfessionalGradeDao.save(teacherProfessionalGrade);
        return k>0;
    }

    @Override
    public Boolean update(TeacherProfessionalGrade teacherProfessionalGrade) {
        //判断教师是否存在
        Teacher teacher=teacherDao.get(teacherProfessionalGrade.getTeacherNumber());
        if(teacher==null){
            throw new MyServiceException("teacherNumber数据有误，请重新提交");
        }
        //判断专业群是否存在
        ProfessionalGrade professionalGrade=professionalGradeDao.get(teacherProfessionalGrade.getProfessionalGradeId());
        if ( professionalGrade== null ){
            throw new MyServiceException("professionalGradeId数据有误，请重新提交");
        }
        //判断该ProfessionalGrade的专业群是否是与该老师一致
        if (!teacher.getProfessional().getId().equals(professionalGrade.getProfessional().getId())){
            throw new MyServiceException("该专业群与实习老师的专业群不一致");
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

    @Override
    public PageObject getNotEnough(Integer page, Integer limit) {
        return null;
    }
}
