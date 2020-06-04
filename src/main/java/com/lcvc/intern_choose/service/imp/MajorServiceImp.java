package com.lcvc.intern_choose.service.imp;

import com.lcvc.intern_choose.dao.MajorDao;
import com.lcvc.intern_choose.dao.ProfessionalDao;
import com.lcvc.intern_choose.model.Major;
import com.lcvc.intern_choose.model.base.PageObject;
import com.lcvc.intern_choose.model.exception.MyWebException;
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
    @Autowired
    private ProfessionalDao professionalDao;
    @Override
    public Major get(@NotNull Integer id) {
        return null;
    }

    @Override
    public List<Major> readAll() {
        ArrayList<Major> list = new ArrayList<>();
        for (Major student : majorDao.readAll(null)) {
            list.add(student);
        }
        return list.size() != 0 ? list : null;
    }

    @Override
    public PageObject query(Integer page, Integer limit, Major major) {
        PageObject pageObject = new PageObject(limit,page,majorDao.querySize(major));
        pageObject.setList(majorDao.query(pageObject.getOffset(),pageObject.getLimit(),major));
        return pageObject;
    }

    @Override
    public Boolean delete(@NotNull Integer id) {
        int k = majorDao.delete(id);
        return k > 0;
    }


    @Override
    public boolean update(Major major) {
        int k = majorDao.update(major);
        return k > 0;
    }

    @Override
    public boolean save(Major major) {

     if (professionalDao.get(major.getProfessionalId()) == null){
         throw new MyWebException("不存在此专业");
     }
        int k = majorDao.save(major);
        return k > 0 ? true : false;
    }
}
