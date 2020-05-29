package com.lcvc.intern_choose.service.imp;

import com.lcvc.intern_choose.model.Classes;
import com.lcvc.intern_choose.model.Grades;
import com.lcvc.intern_choose.service.ClassesServise;
import com.lcvc.intern_choose.service.GradesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GradesServiceImplTest {

    @Autowired
    private GradesService gradesService;

    /**
     * ZF
     * 年级添加方法测试
     * 2020年5月29日10：44
     */
    @Test
    void  save(){
        Grades grades = new Grades();
        grades.setId(5);
        grades.setName("zhangsan");
        System.out.println(gradesService.save(grades));
    }

    /**
     * ZF
     * 年级修改方法测试
     * 2020年5月29日10：44
     */
    @Test
    void  update(){
        Grades grades = new Grades();
        grades.setId(5);
        grades.setName("zhangsan");
        System.out.println(gradesService.save(grades));
    }

    /**
     * ZF
     * 年级删除方法测试
     * 2020年5月29日10：44
     */
    @Test
    void  delete(){
        System.out.println(gradesService.delete(5));
    }

    /**
     * ZF
     * 年级查询方法测试
     * 2020年5月29日10：28
     */
    @Test
    void  get(){
        System.out.println(gradesService.get(6).getName());
    }

    /**
     * ZF
     * 成绩查询方法测试
     * 2020年5月29日10：38
     */
    @Test
    void  realAll(){
        System.out.println(gradesService.readAll());
    }


}