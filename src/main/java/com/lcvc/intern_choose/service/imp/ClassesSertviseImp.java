package com.lcvc.intern_choose.service.imp;

import com.lcvc.intern_choose.dao.ClassesDao;
import com.lcvc.intern_choose.dao.GradesDao;
import com.lcvc.intern_choose.dao.MajorDao;
import com.lcvc.intern_choose.model.Classes;
import com.lcvc.intern_choose.model.base.PageObject;
import com.lcvc.intern_choose.model.exception.MyServiceException;
import com.lcvc.intern_choose.service.ClassesServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class ClassesSertviseImp implements ClassesServise {
    @Autowired
    private ClassesDao classesDao;
    @Autowired
    private MajorDao majorDao;
    @Autowired
    private GradesDao gradesDao;

    @Override
    public Classes get(@NotNull Integer id) {
        return classesDao.get(id);
    }

    @Override
    public List<Classes> readAll() {
        List list = classesDao.readAll(null);
        return list.size() != 0 ? list : null;
    }

    @Override
    public PageObject query(Integer page, Integer limit,Classes classes) {
        PageObject pageObject = new PageObject(limit,page,classesDao.querySize(classes));
        pageObject.setList(classesDao.query(pageObject.getOffset(),pageObject.getLimit(),classes));
        return pageObject;
    }

    @Override
    public Boolean delete(Integer id) {
        int k = classesDao.delete(id);
        return k > 0;
    }

    @Override
    public boolean update(Classes classes) {
        //判断name
        if (classes.getName() != null && !StringUtils.isEmpty(classes.getName())) {
            if (classes.getName().trim().length() < 1 || classes.getName().trim().length() > 10)
                throw new MyServiceException("验证失败：name长度要求1到10之间。");
        } else {
            classes.setName(null);
        }
        //判断major对象是否存在
        if (classes.getMajor() != null) {
            if (majorDao.get(classes.getMajorId()) == null)
                throw new MyServiceException("majorId数据有误，请重新提交");
        }
        //判断grade对象是否存在
        if (classes.getGradeId() != null) {
            if (gradesDao.get(classes.getGradeId()) == null)
                throw new MyServiceException("gradeId数据有误，请重新提交");
        }
        int k = classesDao.update(classes);
        return k > 0;
    }

    @Override
    public boolean save(Classes classes) {
        //判断grade对象是否存在
        if (gradesDao.get(classes.getGradeId()) == null)
            throw new MyServiceException("gradeId数据有误，请重新提交");
        //判断major对象是否存在
        if (majorDao.get(classes.getMajorId()) == null)
            throw new MyServiceException("majorId数据有误，请重新提交");
        int k = classesDao.save(classes);
        return k > 0;
    }
}
