package com.lcvc.intern_choose.util;

import com.lcvc.intern_choose.dao.ClassesDao;
import com.lcvc.intern_choose.dao.GradesDao;
import com.lcvc.intern_choose.dao.MajorDao;
import com.lcvc.intern_choose.dao.ProfessionalDao;
import com.lcvc.intern_choose.model.Classes;
import com.lcvc.intern_choose.model.Major;
import com.lcvc.intern_choose.model.Professional;
import com.lcvc.intern_choose.model.query.ClassesQuery;
import com.lcvc.intern_choose.model.query.MajorQuery;
import com.lcvc.intern_choose.model.query.StudentQuery;
import com.lcvc.intern_choose.model.query.TeacherStudentQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author KEI
 * 2020/6/14 14:29
 *
 * GPMC:grade , professional , Major ,class
 *
 * return  符合条件的班级ids集合,通过班级ids集合查询学生班级
 *
 * 给查询学生时当筛选grade , professional , Major ,class 条件用
 */
@Service
public class StudentQueryByGpmc {
    @Autowired
    private ClassesDao classesDao;
    @Autowired
    private MajorDao majorDao;
    @Autowired
    private GradesDao gradesDao;
    @Autowired
    private ProfessionalDao professionalDao;
    /**
     * 给student的分页查询query使用
     * @param studentQuery
     * @return
     */
    public List<Integer> getClassIds(StudentQuery studentQuery){
        ClassesQuery classesQuery=null;
        List<Integer> classesIds =new ArrayList<>();
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
        Professional professional=professionalDao.get(studentQuery.getProfessionalQuery());
        if (studentQuery.getProfessionalQuery() != null&&professional!=null) {
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
            //上一个条件不为null
            if(studentQuery.getGradeQuery()!=null){
                //取两个集合的交集
                classesIds.retainAll(newClassIds);
            }else{
                classesIds.addAll(newClassIds);
            }

        }

        //如果专业查询字段不为空      majorId-->classIds->Set<Integer> classesIds
        Major major=majorDao.get(studentQuery.getMajorQuery());
        if (studentQuery.getMajorQuery() != null&&major!=null) {
            classesQuery = new ClassesQuery();
            classesQuery.setMajorId(studentQuery.getMajorQuery());
            List<Classes> classesList = classesDao.readAll(classesQuery);
            //创建一个新集合添加班级Id,之后如果有多条件的话则取交集，如果没有的话就全部添加
            List<Integer> newClassIds = new ArrayList<>();
            for (int i = 0; i < classesList.size(); i++) {
                newClassIds.add(classesList.get(i).getId());
            }
            //上两个条件不为null
            if(studentQuery.getGradeQuery()!=null||studentQuery.getProfessionalQuery()!=null){
                //取两个集合的交集，
                classesIds.retainAll(newClassIds);
            }else{
                classesIds.addAll(newClassIds);
            }
        }


        //如果班级不为空 classId-->Set<Integer> classesIds
        Classes classes=classesDao.get(studentQuery.getClassQuery());
        if (studentQuery.getClassQuery() != null&&classes!=null) {
            List<Integer> newClassIds = new ArrayList<>();
            newClassIds.add(studentQuery.getClassQuery());
            //如果classesIds集合数量大于0，取两个集合的交集，否则添加classQuery添加到classIds集合
            if (studentQuery.getGradeQuery()!=null||studentQuery.getProfessionalQuery()!=null||studentQuery.getMajorQuery()!=null) {
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
        return classesIds;
    }

    /**
     * 给teacherStudent的分页查询query使用
     * @param teacherStudentQuery
     * @return
     */
    public List<Integer> getClassIds(TeacherStudentQuery teacherStudentQuery){
        ClassesQuery classesQuery=null;
        List<Integer> classesIds =new ArrayList<>();
        //如果年级不为空  gradeId-->classIds-->Set<Integer> classesIds
        if (teacherStudentQuery.getGradeQuery() != null) {
            classesQuery = new ClassesQuery();
            classesQuery.setGradeId(teacherStudentQuery.getGradeQuery());
            List<Classes> classesList = classesDao.readAll(classesQuery);
            for (int i = 0; i < classesList.size(); i++) {
                classesIds.add(classesList.get(i).getId());
            }
        }

        //如果专业群查询字段不为空   professionalId-->majorIds-->classIds-->Set<Integer> classesIds
        Professional professional=professionalDao.get(teacherStudentQuery.getProfessionalQuery());
        if (teacherStudentQuery.getProfessionalQuery() != null&&professional!=null) {
            //majorIds
            MajorQuery majorQuery = new MajorQuery();
            majorQuery.setProfessionalId(teacherStudentQuery.getProfessionalQuery());
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
            //上一个条件不为null
            if(teacherStudentQuery.getGradeQuery()!=null){
                //取两个集合的交集
                classesIds.retainAll(newClassIds);
            }else{
                classesIds.addAll(newClassIds);
            }

        }

        //如果专业查询字段不为空      majorId-->classIds->Set<Integer> classesIds
        Major major=majorDao.get(teacherStudentQuery.getMajorQuery());
        if (teacherStudentQuery.getMajorQuery() != null&&major!=null) {
            classesQuery = new ClassesQuery();
            classesQuery.setMajorId(teacherStudentQuery.getMajorQuery());
            List<Classes> classesList = classesDao.readAll(classesQuery);
            //创建一个新集合添加班级Id,之后如果有多条件的话则取交集，如果没有的话就全部添加
            List<Integer> newClassIds = new ArrayList<>();
            for (int i = 0; i < classesList.size(); i++) {
                newClassIds.add(classesList.get(i).getId());
            }
            //上两个条件不为null
            if(teacherStudentQuery.getGradeQuery()!=null||teacherStudentQuery.getProfessionalQuery()!=null){
                //取两个集合的交集，
                classesIds.retainAll(newClassIds);
            }else{
                classesIds.addAll(newClassIds);
            }
        }


        //如果班级不为空 classId-->Set<Integer> classesIds
        Classes classes=classesDao.get(teacherStudentQuery.getClassQuery());
        if (teacherStudentQuery.getClassQuery() != null&&classes!=null) {
            List<Integer> newClassIds = new ArrayList<>();
            newClassIds.add(teacherStudentQuery.getClassQuery());
            //如果classesIds集合数量大于0，取两个集合的交集，否则添加classQuery添加到classIds集合
            if (teacherStudentQuery.getGradeQuery()!=null||teacherStudentQuery.getProfessionalQuery()!=null||teacherStudentQuery.getMajorQuery()!=null) {
                classesIds.retainAll(newClassIds);
            } else {
                classesIds.add(teacherStudentQuery.getClassQuery());
            }
        }

        //将set集合的classIds加入查询条件
        Boolean status = (teacherStudentQuery.getClassQuery() != null ||
                teacherStudentQuery.getGradeQuery() != null ||
                teacherStudentQuery.getProfessionalQuery() != null ||
                teacherStudentQuery.getMajorQuery() != null) &&
                classesIds.size() == 0;
        if (status) {
            return null;
        }
        return classesIds;
    }
}
