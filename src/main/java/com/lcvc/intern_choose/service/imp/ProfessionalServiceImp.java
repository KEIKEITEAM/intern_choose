package com.lcvc.intern_choose.service.imp;

import com.lcvc.intern_choose.dao.ProfessionalDao;
import com.lcvc.intern_choose.model.Professional;
import com.lcvc.intern_choose.model.base.PageObject;
import com.lcvc.intern_choose.service.ProfessionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionalServiceImp implements ProfessionalService {

    @Autowired
    private ProfessionalDao professionalDao;

    @Override
    public List<Professional> readAll(Object object) {
        List<Professional> list = professionalDao.readAll(null);
        return list.size() != 0 ? list : null;
    }

    @Override
    public Professional get(Integer id) {
        return professionalDao.get(id);
    }

    @Override
    public Boolean save(Professional professional) {
        int k = professionalDao.save(professional);
        return k == 1 ;
    }

    @Override
    public Boolean update(Professional professional) {
        int k = professionalDao.update(professional);
        return k == 1;
    }

    @Override
    public Boolean delete(Integer id) {
        int k = professionalDao.delete(id);
        return k == 1;
    }

    @Override
    public PageObject query(Integer page, Integer limit, Professional professional) {
        PageObject pageObject = new PageObject(limit,page,professionalDao.querySize(professional));
        pageObject.setList(professionalDao.query(pageObject.getOffset(),pageObject.getLimit(),professional));
        return pageObject;
    }
}
