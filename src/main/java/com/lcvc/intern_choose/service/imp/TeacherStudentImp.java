package com.lcvc.intern_choose.service.imp;

import com.lcvc.intern_choose.dao.StudentDao;
import com.lcvc.intern_choose.dao.TeacherProfessionalGradeDao;
import com.lcvc.intern_choose.dao.TeacherStudentDao;
import com.lcvc.intern_choose.model.Student;
import com.lcvc.intern_choose.model.TeacherProfessionalGrade;
import com.lcvc.intern_choose.model.TeacherStudent;
import com.lcvc.intern_choose.model.base.PageObject;
import com.lcvc.intern_choose.model.exception.MyServiceException;
import com.lcvc.intern_choose.model.query.TeacherProfessionalGradeQuery;
import com.lcvc.intern_choose.model.query.TeacherStudentQuery;
import com.lcvc.intern_choose.service.TeacherStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TeacherStudentImp implements TeacherStudentService {
    @Autowired
    private TeacherStudentDao teacherStudentDao;
    @Autowired
    private TeacherProfessionalGradeDao teacherProfessionalGradeDao;
    @Autowired
    private StudentDao studentDao;
    @Override
    public List<TeacherStudent> readAll(TeacherStudentQuery teacherStudentQuery) {
        return teacherStudentDao.readAll(teacherStudentQuery);
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
        if(studentDao.get(teacherStudent.getStudentNumber())==null){
            throw new MyServiceException("studentNumber输入有误，请重新输入");
        }
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
        if(studentDao.get(teacherStudent.getStudentNumber())==null){
            throw new MyServiceException("studentNumber输入有误，请重新输入");
        }
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

    @Override
    public PageObject getByTeacherNumber(String teacherNumber,Integer professionalGradeId,Integer page, Integer limit) {
        if (professionalGradeId==null){
            throw new MyServiceException("professionalGradeId不能为空");
        }
        //根据teacherNumber查询 TeacherProfessionalGrade对象
        TeacherProfessionalGradeQuery teacherProfessionalGradeQuery = new TeacherProfessionalGradeQuery();
        teacherProfessionalGradeQuery.setTeacherNumber(teacherNumber);
        teacherProfessionalGradeQuery.setProfessionalGradeId(professionalGradeId);
        List<TeacherProfessionalGrade> teacherProfessionalGradeList = teacherProfessionalGradeDao.readAll(teacherProfessionalGradeQuery);
        TeacherProfessionalGrade teacherProfessionalGrade = null;
        if (teacherProfessionalGradeList.size() == 1) {
            teacherProfessionalGrade = teacherProfessionalGradeList.get(0);
        }else {
            throw new MyServiceException("数据有误，请联系管理员");
        }
        //根据tpgId查询 TeacherStudent集合
        TeacherStudentQuery teacherStudentQuery = new TeacherStudentQuery();
        teacherStudentQuery.setTpgId(teacherProfessionalGrade.getId());
        PageObject pageObject = new PageObject(limit,page,teacherStudentDao.querySize(teacherStudentQuery));
        pageObject.setList(teacherStudentDao.query(pageObject.getOffset(),pageObject.getLimit(),teacherStudentQuery));
        return pageObject;
    }

    @Override
    public int batchAdd(String studentNumbers, Integer tpgId) {
        String[] arr=studentNumbers.split(",");
        //获取教师专业群年级对象
        TeacherProfessionalGrade teacherProfessionalGrade=teacherProfessionalGradeDao.get(tpgId);
        int sum=0;
        for (int i = 0; i < arr.length ; i++) {
            //判断该条记录是否存在
            TeacherStudentQuery teacherStudentQuery = null;
            teacherStudentQuery =new TeacherStudentQuery();
            teacherStudentQuery.setStudentNumber(arr[i]);
            int teacherStudentSize=teacherStudentDao.querySize(teacherStudentQuery);
            if (teacherStudentSize==0){
                teacherStudentQuery = new TeacherStudentQuery();
                teacherStudentQuery.setTpgId(tpgId);
                int size= teacherStudentDao.querySize(teacherStudentQuery);
                //判断是否小于教师的学生数量
                if (size<teacherProfessionalGrade.getStudentQuantity()){
                    Student student=studentDao.get(Integer.parseInt(arr[i]));
                    if (student!=null){
                        TeacherStudent teacherStudent=new TeacherStudent();
                        teacherStudent.setStudentNumber(arr[i]);
                        teacherStudent.setTpgId(tpgId);
                        teacherStudent.setCreatTime(new Date());
                        if (teacherStudentDao.save(teacherStudent)>0){
                            sum++;
                        }
                    }
                }
            }
        }
        return sum;
    }
}
