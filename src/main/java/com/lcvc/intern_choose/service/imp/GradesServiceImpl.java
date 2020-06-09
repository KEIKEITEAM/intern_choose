package com.lcvc.intern_choose.service.imp;

import com.lcvc.intern_choose.dao.ClassesDao;
import com.lcvc.intern_choose.dao.GradesDao;
import com.lcvc.intern_choose.model.Grades;
import com.lcvc.intern_choose.model.base.PageObject;
import com.lcvc.intern_choose.model.exception.MyServiceException;
import com.lcvc.intern_choose.model.query.ClassesQuery;
import com.lcvc.intern_choose.service.GradesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class GradesServiceImpl implements GradesService {

    @Autowired
    private GradesDao gradesDao;
    @Autowired
    private ClassesDao classesDao;
    @Override
    public Grades get(@NotNull Integer id) {
        return gradesDao.get(id);
    }

    @Override
    public List<Grades> readAll() {
        List list = gradesDao.readAll(null);
        return list.size() != 0 ? list : null;
    }

    @Override
    public PageObject query(Integer page, Integer limit, Grades grades) {
        PageObject pageObject = new PageObject(limit,page,gradesDao.querySize(grades));
        pageObject.setList(gradesDao.query(pageObject.getOffset(),pageObject.getLimit(),grades));
        return pageObject;
    }

    @Override
    public Boolean delete(@NotNull Integer id) {
        ClassesQuery classesQuery=new ClassesQuery();
        classesQuery.setGradeId(id);
        int sum=classesDao.querySize(classesQuery);
        if (sum!=0){
            throw new MyServiceException("该年级下还有"+sum+"条班级记录，不能删除！");
        }
        return gradesDao.delete(id)==1;
    }

    @Override
    public boolean update(Grades grades) {
        int k = gradesDao.update(grades);
        return k > 0;
    }

    @Override
    public boolean save(Grades grades) {
        int k = gradesDao.save(grades);
        return k > 0;
    }
}
