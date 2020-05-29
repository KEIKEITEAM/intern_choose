package com.lcvc.intern_choose.dao;

import com.lcvc.intern_choose.model.Major;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MajorDaoTest {

    @Autowired
    private MajorDao majorDao;

    @Test
    void readAll() {
        for (Major major : majorDao.readAll()) {
            System.out.println(major);
        }
    }

    @Test
    void save() {
        Major major = new Major();
        major.setName("55");
        major.setProfessionalId(1);
        System.out.println(majorDao.save(major));
    }

    @Test
    void get() {
        System.out.println(majorDao.get(1));
    }

    @Test
    void update() {
        Major major = new Major();
        major.setName("55");
        major.setProfessionalId(1);
        System.out.println(majorDao.update(major));
    }

    @Test
    void delete() {
        System.out.println(majorDao.delete(1));
    }
}