package com.lcvc.intern_choose.service.imp;

import com.lcvc.intern_choose.dao.*;
import com.lcvc.intern_choose.model.*;
import com.lcvc.intern_choose.model.base.PageObject;
import com.lcvc.intern_choose.model.exception.MyServiceException;
import com.lcvc.intern_choose.model.query.*;
import com.lcvc.intern_choose.service.TeacherStudentService;
import com.lcvc.intern_choose.util.StudentQueryByGpmc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class TeacherStudentImp implements TeacherStudentService {
    @Autowired
    private TeacherStudentDao teacherStudentDao;
    @Autowired
    private TeacherProfessionalGradeDao teacherProfessionalGradeDao;
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private MajorDao majorDao;
    @Autowired
    private ProfessionalGradeDao professionalGradeDao;
    @Autowired
    private ClassesDao classesDao;
    @Autowired
    private StudentQueryByGpmc studentQueryByGpmc;

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
        if (studentDao.get(teacherStudent.getStudentNumber()) == null) {
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
        if (studentDao.get(teacherStudent.getStudentNumber()) == null) {
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
        return k > 0;
    }

    @Override
    public PageObject query(Integer page, Integer limit, TeacherStudentQuery teacherStudentQuery) {
        List<Integer> classesIds = studentQueryByGpmc.getClassIds(teacherStudentQuery);
        if (classesIds==null){
            PageObject pageObject= new PageObject(limit, page, 0);
            pageObject.setList(new ArrayList());
            return pageObject;
        }
        teacherStudentQuery.setClassIds(classesIds);
        PageObject pageObject = new PageObject(limit, page, teacherStudentDao.querySize(teacherStudentQuery));
        pageObject.setList(teacherStudentDao.query(pageObject.getOffset(), pageObject.getLimit(), teacherStudentQuery));
        return pageObject;
    }

    @Override
    public PageObject getByTeacherNumber(String teacherNumber, Integer professionalGradeId, Integer page, Integer limit) {
        if (professionalGradeId == null) {
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
        } else {
            throw new MyServiceException("数据有误，请联系管理员");
        }
        //根据tpgId查询 TeacherStudent集合
        TeacherStudentQuery teacherStudentQuery = new TeacherStudentQuery();
        teacherStudentQuery.setTpgId(teacherProfessionalGrade.getId());
        PageObject pageObject = new PageObject(limit, page, teacherStudentDao.querySize(teacherStudentQuery));
        pageObject.setList(teacherStudentDao.query(pageObject.getOffset(), pageObject.getLimit(), teacherStudentQuery));
        return pageObject;
    }

    @Override
    public int batchAdd(String studentNumbers, Integer tpgId) {
        String[] arr = studentNumbers.split(",");
        //获取教师专业群年级对象
        TeacherProfessionalGrade teacherProfessionalGrade = teacherProfessionalGradeDao.get(tpgId);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            //判断该条记录是否存在
            TeacherStudentQuery teacherStudentQuery = null;
            teacherStudentQuery = new TeacherStudentQuery();
            teacherStudentQuery.setStudentNumber(arr[i]);
            int teacherStudentSize = teacherStudentDao.querySize(teacherStudentQuery);
            if (teacherStudentSize == 0) {
                teacherStudentQuery = new TeacherStudentQuery();
                teacherStudentQuery.setTpgId(tpgId);
                int size = teacherStudentDao.querySize(teacherStudentQuery);
                //判断是否小于教师的学生数量
                if (size < teacherProfessionalGrade.getStudentQuantity()) {
                    Student student = studentDao.get(Integer.parseInt(arr[i]));
                    if (student != null) {
                        TeacherStudent teacherStudent = new TeacherStudent();
                        teacherStudent.setStudentNumber(arr[i]);
                        teacherStudent.setTpgId(tpgId);
                        teacherStudent.setCreatTime(new Date());
                        if (teacherStudentDao.save(teacherStudent) > 0) {
                            sum++;
                        }
                    }
                }
            }
        }
        return sum;
    }

    @Override
    public String randomChooseStudent(Integer tpgId) {
        //获取teacherProfessionalGrade对象
        TeacherProfessionalGrade tpg = teacherProfessionalGradeDao.get(tpgId);
        if (tpg == null) {
            throw new MyServiceException("提交的tpgId数据有误，请重新提交");
        }
        //判断该老师的实习名额是否已满
        TeacherStudentQuery teacherStudentQuery = null;
        teacherStudentQuery = new TeacherStudentQuery();
        teacherStudentQuery.setTpgId(tpgId);
        int size = teacherStudentDao.querySize(teacherStudentQuery);
        if (size >= tpg.getStudentQuantity()) {
            throw new MyServiceException("该老师的实习名额已满");
        }
        //获取professionalGrade对象
        ProfessionalGrade professionalGrade = professionalGradeDao.get(tpg.getProfessionalGrade().getId());
        //获取该专业群相对应的开放权限的专业
        MajorQuery majorQuery = new MajorQuery();
        majorQuery.setProfessionalId(professionalGrade.getProfessional().getId());
        majorQuery.setAvailableOpen(true);
        majorQuery.setOpen(true);
        List<Major> majorList = majorDao.readAll(majorQuery);
        //将专业集合的专业id加入集合
        List<Integer> majorIds = new ArrayList<>();
        for (int i = 0; i < majorList.size(); i++) {
            majorIds.add(majorList.get(i).getId());
        }
        //根据年级id和majorids集合查询班级
        ClassesQuery classesQuery = new ClassesQuery();
        classesQuery.setGradeId(professionalGrade.getGrades().getId());
        classesQuery.setMajorIds(majorIds);
        List<Classes> classesList = classesDao.readAll(classesQuery);
        List<Integer> classIds = new ArrayList<>();
        //将班级集合的id加入集合
        for (int i = 0; i < classesList.size(); i++) {
            classIds.add(classesList.get(i).getId());
        }
        //根据班级ids和已选择实习老师的学生学号集合查询
        List<TeacherStudent> teacherStudentList = teacherStudentDao.readAll(null);
        int studentNumberLength = teacherStudentList.size();
        String[] studentNumbers = new String[studentNumberLength];
        for (int i = 0; i < studentNumberLength; i++) {
            studentNumbers[i] = teacherStudentList.get(i).getStudent().getStudentNumber();
        }
        //根据已选择实习老师的学生学号和班级集合查询学生集合
        StudentQuery studentQuery = new StudentQuery();
        studentQuery.setStudentNumbers(studentNumbers);
        studentQuery.setClassIds(classIds);
        List<Student> studentList = studentDao.readAll(studentQuery);
        if (studentList.size() == 0) {
            throw new MyServiceException("可供该老师分配的学生数量为0");
        }
        //随机分配学生
        Random r = new Random();
        int sum = 0;
        while (studentList.size() > 0) {
            //判断该实习老师手下的实习学生数量是否超出
            if (tpg.getStudentQuantity() - size == sum) {
                break;
            }
            TeacherStudent teacherStudent = new TeacherStudent();
            int i = r.nextInt(studentList.size());
            teacherStudent.setStudentNumber(studentList.get(i).getStudentNumber());
            teacherStudent.setTpgId(tpgId);
            teacherStudent.setCreatTime(new Date());
            if (teacherStudentDao.save(teacherStudent) > 0) {
                sum++;
            }
            studentList.remove(i);
        }
        return "该老师有" + tpg.getStudentQuantity() + "名实习生名额,已选" + size + "名,本次分配了" + sum + "名实习生";
    }
}
