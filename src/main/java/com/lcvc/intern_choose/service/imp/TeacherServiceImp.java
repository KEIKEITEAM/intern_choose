package com.lcvc.intern_choose.service.imp;

import com.lcvc.intern_choose.dao.ProfessionalDao;
import com.lcvc.intern_choose.dao.TeacherDao;
import com.lcvc.intern_choose.dao.TeacherProfessionalGradeDao;
import com.lcvc.intern_choose.dao.TeacherStudentDao;
import com.lcvc.intern_choose.model.Teacher;
import com.lcvc.intern_choose.model.base.PageObject;
import com.lcvc.intern_choose.model.exception.MyServiceException;
import com.lcvc.intern_choose.model.exception.MyWebException;
import com.lcvc.intern_choose.model.form.TeacherPasswordForm;
import com.lcvc.intern_choose.model.query.TeacherQuery;
import com.lcvc.intern_choose.service.TeacherService;
import com.lcvc.intern_choose.util.SHA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class TeacherServiceImp implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;
    @Autowired
    private TeacherProfessionalGradeDao teacherProfessionalGradeDao;
    @Autowired
    private TeacherStudentDao teacherStudentDao;
    @Autowired
    private ProfessionalDao professionalDao;

    @Override
    public Teacher get(String id) {
        Teacher teacher = teacherDao.get(id);
        return teacher;
    }


    @Override
    public boolean login(String teacherNumber, String password) {
        boolean judge = false;
        if (StringUtils.isEmpty(teacherNumber)) {
            throw new MyWebException("登陆失败：工号不能为空");
        } else if (StringUtils.isEmpty(password)) {
            throw new MyWebException("登陆失败：密码不能为空");
        } else {
            if (teacherDao.login(teacherNumber, SHA.getResult(password)) == 1) {
                judge = true;
            }
        }
        return judge;
    }


    @Override
    public List<Teacher> readAll(TeacherQuery teacherQuery) {
        List list = teacherDao.readAll(teacherQuery);
        return list.size() != 0 ? list : null;
    }


    @Override
    public Boolean delete(@NotNull String teacherNumber) {
        int k = teacherDao.delete(teacherNumber);
        return k > 0;
    }


    @Override
    public boolean update(Teacher teacher) {
        if (teacher.getProfessionalId()!=null){
            if (professionalDao.get(teacher.getProfessionalId()) == null){
                throw new MyWebException("不存在此专业群");
            }
        }
        if (teacher.getPassword()!=null){
            teacher.setPassword(teacher.getPassword());
        }
        int k = teacherDao.update(teacher);
        return k > 0;
    }


    @Override
    public boolean save(Teacher teacher) {
        if (professionalDao.get(teacher.getProfessionalId()) == null){
            throw new MyWebException("不存在此专业群");
        }
        if (teacher.getPassword()!=null){
            teacher.setPassword(teacher.getPassword());
        }
        int k = teacherDao.save(teacher);
        return k > 0 ;
    }



    @Override
    public PageObject query(Integer page, Integer limit, TeacherQuery teacherQuery) {
        PageObject pageObject = new PageObject(limit,page,teacherDao.querySize(teacherQuery));
        pageObject.setList(teacherDao.query(pageObject.getOffset(),pageObject.getLimit(),teacherQuery));
        return pageObject;
    }

    @Override
    public Boolean updatePassword(TeacherPasswordForm teacherPasswordForm, String teacherNumber) {
        Teacher teacher=teacherDao.get(teacherNumber);
        if (!teacher.getPassword().equals(SHA.getResult(teacherPasswordForm.getPassword()))){
            throw new MyServiceException("与原密码不一致");
        }
        if (!teacherPasswordForm.getNewPassword().equals(teacherPasswordForm.getConfirmPassword())){
            throw new MyServiceException("新密码与确认密码不一致");
        }
        Teacher newTeacher=new Teacher();
        newTeacher.setTeacherNumber(teacherNumber);
        newTeacher.setPassword(SHA.getResult(teacherPasswordForm.getNewPassword()));

        return teacherDao.update(newTeacher)>0;
    }

}
