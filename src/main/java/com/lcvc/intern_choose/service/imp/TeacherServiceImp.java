package com.lcvc.intern_choose.service.imp;

import com.lcvc.intern_choose.dao.TeacherDao;
import com.lcvc.intern_choose.dao.TeacherProfessionalGradeDao;
import com.lcvc.intern_choose.dao.TeacherStudentDao;
import com.lcvc.intern_choose.model.Teacher;
import com.lcvc.intern_choose.model.TeacherProfessionalGrade;
import com.lcvc.intern_choose.model.TeacherStudent;
import com.lcvc.intern_choose.model.base.PageObject;
import com.lcvc.intern_choose.model.exception.MyWebException;
import com.lcvc.intern_choose.model.query.TeacherProfessionalGradeQuery;
import com.lcvc.intern_choose.model.query.TeacherQuery;
import com.lcvc.intern_choose.model.query.TeacherStudentQuery;
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

    public Teacher get(String id) {
        Teacher teacher = teacherDao.get(id);
        return teacher;
    }


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


    public List<Teacher> readAll() {
        List list = teacherDao.readAll(null);
        return list.size() != 0 ? list : null;
    }


    public Boolean delete(@NotNull String teacherNumber) {
        int k = teacherDao.delete(teacherNumber);
        return k > 0 ? true : false;
    }


    public boolean update(Teacher teacher) {
        int k = teacherDao.update(teacher);
        return k > 0 ? true : false;
    }


    public boolean save(Teacher teacher) {
        int k = teacherDao.save(teacher);
        return k > 0 ? true : false;
    }

    @Override
    public List<TeacherStudent> getByTeacherNumber(String teacherNumber) {
        //根据teacherNumber查询 TeacherProfessionalGrade对象
        TeacherProfessionalGradeQuery teacherProfessionalGradeQuery = new TeacherProfessionalGradeQuery();
        teacherProfessionalGradeQuery.setTeacherNumber(teacherNumber);
        List<TeacherProfessionalGrade> teacherProfessionalGradeList = teacherProfessionalGradeDao.readAll(teacherProfessionalGradeQuery);
        TeacherProfessionalGrade teacherProfessionalGrade = null;
        if (teacherProfessionalGradeList.size() == 1)
            teacherProfessionalGrade = teacherProfessionalGradeList.get(0);

        //根据tpgId查询 TeacherStudent集合
        TeacherStudentQuery teacherStudentQuery = new TeacherStudentQuery();
        teacherStudentQuery.setTpgId(teacherProfessionalGrade.getId());
        List<TeacherStudent> list = teacherStudentDao.readAll(teacherStudentQuery);

        return list.size() != 0 ? list : null;
    }

    @Override
    public PageObject query(Integer page, Integer limit, TeacherQuery teacherQuery) {
        PageObject pageObject = new PageObject(limit,page,teacherDao.querySize(teacherQuery));
        pageObject.setList(teacherDao.query(pageObject.getOffset(),pageObject.getLimit(),teacherQuery));
        return pageObject;
    }

}
