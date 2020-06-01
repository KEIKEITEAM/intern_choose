package com.lcvc.intern_choose.dao;

import com.lcvc.intern_choose.model.Professional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProfessionalDaoTests {
    @Autowired
    private ProfessionalDao professionalDao;
    @Test
    void save(){
        Professional professional=new Professional();
        professional.setName("软件专业群");
       System.out.println(professionalDao.save(professional));
    }

    @Test
    void update(){
        Professional professional=new Professional();
        professional.setName("软件专业群1");
        professional.setId(1);
        System.out.println(professionalDao.update(professional));
    }

    @Test
    void get(){
        System.out.println(professionalDao.get(1));
    }

    @Test
    void delete(){
        System.out.println(professionalDao.delete(9));
    }

    @Test
    void readAll(){
        System.out.println(professionalDao.readAll(null));
    }


}
