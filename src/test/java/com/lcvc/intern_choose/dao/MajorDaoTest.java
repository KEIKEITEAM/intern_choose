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
    }

    @Test
    void get() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}