package com.lcvc.intern_choose.service.imp;

import com.lcvc.intern_choose.dao.ClassesDao;
import com.lcvc.intern_choose.model.Classes;
import com.lcvc.intern_choose.model.exception.MyServiceException;
import com.lcvc.intern_choose.service.ClassesServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class ClassesSertviseImp implements ClassesServise {
    @Autowired
    private ClassesDao classesDao;


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
    public Boolean delete(Integer id) {
        int k = classesDao.delete(id);
        return k > 0 ? true : false;
    }

    @Override
    public boolean update(Classes classes) {
        int k = classesDao.update(classes);
        return k > 0 ? true : false;
    }

    @Override
    public boolean save(Classes classes) {
        int k = classesDao.save(classes);
        return k > 0 ? true : false;
    }
}
