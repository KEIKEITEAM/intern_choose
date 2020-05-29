package com.lcvc.intern_choose.service.imp;

import com.lcvc.intern_choose.dao.MajorDao;
import com.lcvc.intern_choose.model.Major;
import com.lcvc.intern_choose.service.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Service
public class MajorServiceImp implements MajorService {
    @Autowired
    private MajorDao majorDao;
    @Override
    public Major get(@NotNull Integer id) {
        return null;
    }

    @Override
    public List<Major> readAll() {
        ArrayList<Major> list = new ArrayList<>();
        for (Major student : majorDao.readAll()) {
            list.add(student);
        }
        return list.size() != 0 ? list : null;
    }

    @Override
    public Boolean delete(@NotNull Integer id) {
        int k = majorDao.delete(id);
        return k > 0 ? true : false;
    }
    

    @Override
    public boolean update(Major Major) {
        int k = majorDao.update(Major);
        return k > 0 ? true : false;
    }

    @Override
    public boolean save(Major Major) {
        int k = majorDao.save(Major);
        return k > 0 ? true : false;
    }
}
