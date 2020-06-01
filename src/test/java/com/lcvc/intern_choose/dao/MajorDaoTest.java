package com.lcvc.intern_choose.dao;

import com.lcvc.intern_choose.model.Major;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MajorDaoTest {

    @Autowired
    private MajorDao majorDao;
    /**
     * liang
     * 专业添加方法测试
     * 2020年5月29日19:25
     */
    @Test
    void readAll() {
        for (Major major : majorDao.readAll(null)) {
            System.out.println(major);
        }
    }

    /**
     * liang
     * 专业添加方法测试
     * 2020年5月29日19:25
     */
    @Test
    void save() {
        Major major = new Major();
        major.setName("55");
        major.setProfessionalId(1);
        System.out.println(majorDao.save(major));
    }

    /**
     * liang
     * 专业查询方法测试
     * 2020年5月29日19:25
     */
    @Test
    void get() {
        System.out.println(majorDao.get(2));
    }

    /**
     * liang
     * 专业修改方法测试
     * 2020年5月29日19:25
     */
    @Test
    void update() {
        Major major = new Major();
        major.setName("55");
        major.setProfessionalId(1);
        System.out.println(majorDao.update(major));
    }

    /**
     * liang
     * 专业删除方法测试
     * 2020年5月29日19:25
     */
    @Test
    void delete() {
        System.out.println(majorDao.delete(1));
    }
}