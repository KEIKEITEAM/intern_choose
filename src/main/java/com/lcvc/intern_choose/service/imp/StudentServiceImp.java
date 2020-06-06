package com.lcvc.intern_choose.service.imp;

import com.lcvc.intern_choose.dao.*;
import com.lcvc.intern_choose.model.*;
import com.lcvc.intern_choose.model.base.PageObject;
import com.lcvc.intern_choose.model.exception.MyServiceException;
import com.lcvc.intern_choose.model.exception.MyWebException;
import com.lcvc.intern_choose.model.form.StudentPasswordForm;
import com.lcvc.intern_choose.model.query.ProfessionalGradeQuery;
import com.lcvc.intern_choose.model.query.StudentQuery;
import com.lcvc.intern_choose.model.query.TeacherProfessionalGradeQuery;
import com.lcvc.intern_choose.model.query.TeacherStudentQuery;
import com.lcvc.intern_choose.service.StudentService;
import com.lcvc.intern_choose.util.IsInDate;
import com.lcvc.intern_choose.util.SHA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.util.Date;
import java.util.List;


@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentDao studentDao;
    @Autowired
    private ProfessionalDao professionalDao;
    @Autowired
    private MajorDao majorDao;
    @Autowired
    private ClassesDao classesDao;
    @Autowired
    private ProfessionalGradeDao professionalGradeDao;
    @Autowired
    private TeacherProfessionalGradeDao teacherProfessionalGradeDao;
    @Autowired
    private TeacherStudentDao teacherStudentDao;
    @Autowired
    private TeacherDao teacherDao;

    @Override
    public Student get(String id) {
        Student student = studentDao.get(id);
        return student;
    }


    @Override
    public boolean login(String studentNumber, String password) {
        boolean judge = false;
        if (StringUtils.isEmpty(studentNumber)) {
            throw new MyWebException("登陆失败：学号不能为空");
        } else if (StringUtils.isEmpty(password)) {
            throw new MyWebException("登陆失败：密码不能为空");
        } else {
            if (studentDao.login(studentNumber, SHA.getResult(password)) == 1) {
                judge = true;
            }
        }
        return judge;
    }

    @Override
    public List<Student> readAll(StudentQuery studentQuery) {
        List<Student> list = studentDao.readAll(studentQuery);
        return list.size() > 0 ? list : null;
    }

    @Override
    public Boolean delete(@NotNull String teacherNumber) {
        int k = studentDao.delete(teacherNumber);
        return k > 0 ;
    }

    @Override
    public boolean update(Student student) {
        if (student.getClassId()!=null){
            if(classesDao.get(student.getClassId())==null){
                throw new MyServiceException("不存在此专业");
            }
        }
        if (student.getPassword()!=null){
            student.setPassword(SHA.getResult(student.getPassword()));
        }
        int k = studentDao.update(student);
        return k > 0 ;
    }


    @Override
    public boolean save(Student student) {
        if(classesDao.get(student.getClassId())==null){
            throw new MyServiceException("不存在此专业");
        }
        if (student.getPassword()!=null){
            student.setPassword(SHA.getResult(student.getPassword()));
        }
        int k = studentDao.save(student);
        return k > 0 ;
    }

    @Override
    public void choose(String studentNumber, String teacherNumber) throws ParseException {
        Student student = studentDao.get(studentNumber);
        Classes classes = classesDao.get(student.getClasses().getId());
        Major major = majorDao.get(classes.getMajor().getId());

        Professional professional = professionalDao.get(major.getProfessional().getId());
        ProfessionalGradeQuery professionalGradeQuery = new ProfessionalGradeQuery();
        professionalGradeQuery.setProfessionalId(professional.getId());
        professionalGradeQuery.setGradeId(classes.getGrades().getId());
        List<ProfessionalGrade> list = professionalGradeDao.readAll(professionalGradeQuery);
        if (list.size() != 1) {
            throw new MyServiceException("数据有误，请联系管理员");
        }
        ProfessionalGrade professionalGrade = list.get(0);
        //判断是否开放选择权限
        if (professionalGrade.isOpen()) {
            //判断当前时间是不是在开放的时间范围内
            if (IsInDate.judge(new Date(), professionalGrade.getStartTime(), professionalGrade.getEndTime())) {
                Teacher teacher = teacherDao.get(teacherNumber);
                //如果教师工号为null
                if (teacher == null) {
                    throw new MyServiceException("教师ID有误，请重新提交");
                }
                //判断该学生的专业群是否跟该实习老师的专业群一致
                if (major.getProfessional().getId().equals(teacher.getProfessional().getId())) {
                    //根据学号判断是不是已经选择过实习老师
                    TeacherStudentQuery teacherStudentQuery = null;
                    teacherStudentQuery = new TeacherStudentQuery();
                    teacherStudentQuery.setStudentNumber(studentNumber);
                    int sum = teacherStudentDao.querySize(teacherStudentQuery);
                    if (sum == 0) {
                        TeacherProfessionalGradeQuery teacherProfessionalGradeQuery = new TeacherProfessionalGradeQuery();
                        teacherProfessionalGradeQuery.setProfessionalGradeId(professionalGrade.getId());
                        teacherProfessionalGradeQuery.setTeacherNumber(teacherNumber);
                        List<TeacherProfessionalGrade> teacherProfessionalGradeList = teacherProfessionalGradeDao.readAll(teacherProfessionalGradeQuery);
                        TeacherProfessionalGrade tpg = null;
                        if (teacherProfessionalGradeList.size() == 1) {
                            tpg = teacherProfessionalGradeList.get(0);
                        }
                        teacherStudentQuery = new TeacherStudentQuery();
                        teacherStudentQuery.setTpgId(tpg.getId());
                        int studentSum = teacherStudentDao.querySize(teacherStudentQuery);
                        //判断选择了该实习老师的学生数量
                        if (tpg.getStudentQuantity() > studentSum) {
                            TeacherStudent teacherStudent = new TeacherStudent();
                            teacherStudent.setStudentNumber(studentNumber);
                            teacherStudent.setTpgId(tpg.getId());
                            teacherStudent.setCreatTime(new Date());
                            teacherStudentDao.save(teacherStudent);
                        } else {
                            throw new MyServiceException("该老师的学生学生名额已满");
                        }
                    } else if (sum == 1) {
                        throw new MyServiceException("您已经选择了实习老师");
                    } else {
                        throw new MyServiceException("您的数据有误，请联系管理员");
                    }
                } else {
                    throw new MyServiceException("该老师不是您的专业群的老师");
                }
            } else {
                throw new MyServiceException("目前不是填报时间");
            }
        } else {
            throw new MyServiceException("您没有权限操作");
        }

    }

    @Override
    public Teacher getTeacher(String studentNumber) {
        Teacher teacher = new Teacher();
        //根据学号查询teacher_student表
        TeacherStudent teacherStudent = teacherStudentDao.getByStudentNumber(studentNumber);
        if (teacherStudent == null) {
            return null;
        }
        //根据teacherStduent表的tpgId查询teacher_professional_grade
        TeacherProfessionalGrade tpg = teacherProfessionalGradeDao.get(teacherStudent.getTpgId());
        //根据tpg表里的teacherNumber查询教师信息表
        teacher = teacherDao.get(tpg.getTeacherNumber());
        //设置学生数量
        teacher.setStudentQuantity(tpg.getStudentQuantity());
        //查询专业群
        Professional professional = professionalDao.get(teacher.getProfessionalId());
        return teacher;
    }

    @Override
    public List<TeacherProfessionalGrade> getAvailableTeacher(Integer classesId) {
        Classes classes = classesDao.get(classesId);
        Major major = majorDao.get(classes.getMajor().getId());

        //查询条件
        ProfessionalGradeQuery professionalGradeQuery = new ProfessionalGradeQuery();
        professionalGradeQuery.setOpen(true);
        professionalGradeQuery.setAvailableOpen(true);
        professionalGradeQuery.setProfessionalId(major.getProfessional().getId());
        professionalGradeQuery.setGradeId(classes.getGrades().getId());
        ProfessionalGrade professionalGrade = professionalGradeDao.readAll(professionalGradeQuery).get(0);

        TeacherProfessionalGradeQuery teacherProfessionalGradeQuery = new TeacherProfessionalGradeQuery();
        teacherProfessionalGradeQuery.setProfessionalGradeId(professionalGrade.getId());
        List<TeacherProfessionalGrade> list = teacherProfessionalGradeDao.readAll(teacherProfessionalGradeQuery);
        return list.size() > 0 ? list : null;
    }

    @Override
    public PageObject query(Integer page, Integer limit, StudentQuery studentQuery) {
        PageObject pageObject = new PageObject(limit,page,studentDao.querySize(studentQuery));
        pageObject.setList(studentDao.query(pageObject.getOffset(),pageObject.getLimit(),studentQuery));
        return pageObject;
    }

    @Override
    public Boolean updatePassword(StudentPasswordForm studentPasswordForm, String studentNumber) {
        Student student=studentDao.get(studentNumber);
        if (!student.getPassword().equals(SHA.getResult(studentPasswordForm.getPassword()))){
            throw new MyServiceException("与原密码不一致");
        }
        if (!studentPasswordForm.getNewPassword().equals(studentPasswordForm.getConfirmPassword())){
            throw new MyServiceException("新密码与确认密码不一致");
        }
        Student newStduent=new Student();
        newStduent.setStudentNumber(studentNumber);
        newStduent.setPassword(SHA.getResult(studentPasswordForm.getNewPassword()));

        return studentDao.update(newStduent)>0;
    }

}
