package com.lcvc.intern_choose.service.imp;

import com.lcvc.intern_choose.dao.*;
import com.lcvc.intern_choose.model.*;
import com.lcvc.intern_choose.model.base.PageObject;
import com.lcvc.intern_choose.model.exception.MyServiceException;
import com.lcvc.intern_choose.model.exception.MyWebException;
import com.lcvc.intern_choose.model.form.StudentPasswordForm;
import com.lcvc.intern_choose.model.query.*;
import com.lcvc.intern_choose.service.StudentService;
import com.lcvc.intern_choose.util.IsInDate;
import com.lcvc.intern_choose.util.SHA;
import com.lcvc.intern_choose.util.StudentQueryByGpmc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.util.ArrayList;
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
    @Autowired
    private StudentQueryByGpmc studentQueryByGpmc;

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
        return k > 0;
    }

    @Override
    public boolean update(Student student) {
        if (student.getClassId() != null) {
            if (classesDao.get(student.getClassId()) == null) {
                throw new MyServiceException("不存在此专业");
            }
        }
        if (student.getPassword() != null) {
            student.setPassword(SHA.getResult(student.getPassword()));
        }
        int k = studentDao.update(student);
        return k > 0;
    }


    @Override
    public boolean save(Student student) {
        if (classesDao.get(student.getClassId()) == null) {
            throw new MyServiceException("不存在此专业");
        }
        if (student.getPassword() != null) {
            student.setPassword(SHA.getResult(student.getPassword()));
        } else {
            student.setPassword(SHA.getResult(student.getStudentNumber()));
        }

        int k = studentDao.save(student);
        return k > 0;
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
        if (professionalGrade.isOpen() && major.getOpen()) {
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
        teacher = teacherDao.get(tpg.getTeacher().getTeacherNumber());
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
        if (!major.getOpen()) {
            throw new MyServiceException("还没有开放您专业的选择权限");
        }
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

    /**
     * 思路：
     * 根据年级、专业群、专业、班级等条件查询都能获取到该学生的班级Id，
     * 单条件的话，则判断是否能查到班级ids，
     * 如果有多条件的话，则按照年级、专业群、专业、班级的大小范围依次取之交集，则得到多条件下的那个班级
     * 最后判断查询条件是否为空和classesIds.size()是否>0,如果否返回null
     */
    @Override
    public PageObject query(Integer page, Integer limit, StudentQuery studentQuery) {
/*
        //如果年级不为空  gradeId-->classIds-->Set<Integer> classesIds
        if (studentQuery.getGradeQuery() != null) {
            classesQuery = new ClassesQuery();
            classesQuery.setGradeId(studentQuery.getGradeQuery());
            List<Classes> classesList = classesDao.readAll(classesQuery);
            for (int i = 0; i < classesList.size(); i++) {
                classesIds.add(classesList.get(i).getId());
            }
        }

        //如果专业群查询字段不为空   professionalId-->majorIds-->classIds-->Set<Integer> classesIds
        if (studentQuery.getProfessionalQuery() != null) {
            //majorIds
            MajorQuery majorQuery = new MajorQuery();
            majorQuery.setProfessionalId(studentQuery.getProfessionalQuery());
            List<Major> majorList = majorDao.readAll(majorQuery);
            List<Integer> majorIds = new ArrayList<>();
            for (int i = 0; i < majorList.size(); i++) {
                majorIds.add(majorList.get(i).getId());
            }
            //classIds
            classesQuery = new ClassesQuery();
            classesQuery.setMajorIds(majorIds);
            List<Classes> classesList = classesDao.readAll(classesQuery);
            //创建集合
            List<Integer> newClassIds = new ArrayList<>();
            for (int i = 0; i < classesList.size(); i++) {
                newClassIds.add(classesList.get(i).getId());
            }
            //取两个集合的交集，
            classesIds.retainAll(newClassIds);
        }

        //如果专业查询字段不为空      majorId-->classIds->Set<Integer> classesIds
        if (studentQuery.getMajorQuery() != null) {
            classesQuery = new ClassesQuery();
            classesQuery.setMajorId(studentQuery.getMajorQuery());
            List<Classes> classesList = classesDao.readAll(classesQuery);
            //创建一个新集合添加班级Id,之后如果有多条件的话则取交集，如果没有的话就全部添加
            List<Integer> newClassIds = new ArrayList<>();
            for (int i = 0; i < classesList.size(); i++) {
                newClassIds.add(classesList.get(i).getId());
            }
            //取两个集合的交集，
            classesIds.retainAll(newClassIds);
        }
        //如果班级不为空 classId-->Set<Integer> classesIds
        if (studentQuery.getClassQuery() != null) {
            List<Integer> newClassIds = new ArrayList<>();
            newClassIds.add(studentQuery.getClassQuery());
            //如果classesIds集合数量大于0，取两个集合的交集，否则添加classQuery添加到classIds集合
            if (classesIds.size() > 0) {
                classesIds.retainAll(newClassIds);
            } else {
                classesIds.add(studentQuery.getClassQuery());
            }
        }
        //将set集合的classIds加入查询条件
        Boolean status = (studentQuery.getClassQuery() != null ||
                studentQuery.getGradeQuery() != null ||
                studentQuery.getProfessionalQuery() != null ||
                studentQuery.getMajorQuery() != null) &&
                classesIds.size() == 0;
        if (status) {
            return null;
        }

 */

        List<Integer> classesIds = studentQueryByGpmc.getClassIds(studentQuery);
        studentQuery.setClassIds(classesIds);
        PageObject pageObject = new PageObject(limit, page, studentDao.querySize(studentQuery));
        pageObject.setList(studentDao.query(pageObject.getOffset(), pageObject.getLimit(), studentQuery));
        return pageObject;
    }

    @Override
    public Boolean updatePassword(StudentPasswordForm studentPasswordForm, String studentNumber) {
        Student student = studentDao.get(studentNumber);
        if (!student.getPassword().equals(SHA.getResult(studentPasswordForm.getPassword()))) {
            throw new MyServiceException("与原密码不一致");
        }
        if (!studentPasswordForm.getNewPassword().equals(studentPasswordForm.getConfirmPassword())) {
            throw new MyServiceException("新密码与确认密码不一致");
        }
        Student newStduent = new Student();
        newStduent.setStudentNumber(studentNumber);
        newStduent.setPassword(SHA.getResult(studentPasswordForm.getNewPassword()));

        return studentDao.update(newStduent) > 0;
    }

    @Override
    public PageObject getNotChooseStudent(int page, int limit, StudentQuery studentQuery) {
        List<TeacherStudent> teacherStudentList = teacherStudentDao.readAll(null);
        int length = teacherStudentList.size();
        String s[] = new String[length];
        for (int i = 0; i < length; i++) {
            s[i] = teacherStudentList.get(i).getStudent().getStudentNumber();
        }
        studentQuery.setStudentNumbers(s);
        PageObject pageObject = new PageObject(limit, page, studentDao.querySize(studentQuery));
        pageObject.setList(studentDao.query(pageObject.getOffset(), pageObject.getLimit(), studentQuery));
        return pageObject;
    }

    @Override
    public PageObject getOpenStudent(Integer page, Integer limit) {
        //获取开放权限的年级专业群集合
        ProfessionalGradeQuery professionalGradeQuery = new ProfessionalGradeQuery();
        professionalGradeQuery.setAvailableOpen(true);
        professionalGradeQuery.setOpen(true);
        professionalGradeQuery.setAvailableOpen(true);
        List<ProfessionalGrade> professionalGradeList = professionalGradeDao.readAll(professionalGradeQuery);
        if (professionalGradeList.size() == 0) {
            return null;
        }
        //通过开放的年级专业群集合查找专业群
        List<Integer> professinalIds = new ArrayList<>();
        for (int i = 0; i < professionalGradeList.size(); i++) {
            int id = professionalGradeList.get(i).getProfessional().getId();
            professinalIds.add(id);
        }

        MajorQuery majorQuery = new MajorQuery();
        majorQuery.setProfessionalIds(professinalIds);
        majorQuery.setAvailableOpen(true);
        majorQuery.setOpen(true);
        List<Major> majorList = majorDao.readAll(majorQuery);
        if (majorList.size() == 0) {
            return null;
        }
        List<Integer> majorIds = new ArrayList<>();
        for (int i = 0; i < majorList.size(); i++) {
            majorIds.add(majorList.get(i).getId());
        }
        //获取classIds
        ClassesQuery classesQuery = new ClassesQuery();
        classesQuery.setMajorIds(majorIds);
        List<Classes> classesList = classesDao.readAll(classesQuery);
        if (classesList.size() == 0) {
            return null;
        }
        List<Integer> classIds = new ArrayList<>();
        for (int i = 0; i < classesList.size(); i++) {
            classIds.add(classesList.get(i).getId());
        }
        StudentQuery studentQuery = new StudentQuery();
        studentQuery.setClassIds(classIds);
        PageObject pageObject = new PageObject(limit, page, studentDao.querySize(studentQuery));
        pageObject.setList(studentDao.query(pageObject.getOffset(), pageObject.getLimit(), studentQuery));
        return pageObject;
    }




}
