package com.lcvc.intern_choose.dao;

import com.lcvc.intern_choose.model.Classes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ClassesDaoTests {
        @Autowired
        private  ClassesDao classesDao;


    /**
     * ZF
     * 年级添加方法测试
     * 2020年5月29日10：44
     */
    @Test
    void  save(){
        Classes classes=new Classes();
        classes.setMajorId(1);
        classes.setGradeId(1);
        classes.setName("20");
        System.out.println(classesDao.save(classes));
    }

    /**
     * ZF
     * 年级修改方法测试
     * 2020年5月29日10：44
     */
    @Test
    void  update(){
        Classes classes=new Classes();
        classes.setMajorId(22);
        classes.setGradeId(2);
        classes.setName("20");
        classes.setId(1);
        System.out.println(classesDao.update(classes));
    }

    /**
     * ZF
     * 年级删除方法测试
     * 2020年5月29日10：44
     */
    @Test
    void  delete(){
        System.out.println(classesDao.delete(9));
    }

    /**
     * ZF
     * 年级查询方法测试
     * 2020年5月29日10：28
     */
    @Test
    void  get(){
        System.out.println(classesDao.get(1));
    }

    /**
     * ZF
     * 年级查询方法测试
     * 2020年5月29日10：38
     */
    @Test
    void  realAll(){
        System.out.println(classesDao.readAll(null));
    }
}
