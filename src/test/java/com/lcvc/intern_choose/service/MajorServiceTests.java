package com.lcvc.intern_choose.service;

import com.lcvc.intern_choose.model.Major;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MajorServiceTests {
    @Autowired
    private MajorService majorService;
    /**
     * liang
     * 专业添加方法测试
     * 2020年5月29日10：44
     */
    @Test
    void  save(){
        Major major = new Major();
        major.setProfessionalId(1);
        major.setName("1");
        major.setId(1);
        System.out.println(majorService.save(major));
    }

    /**
     * liang
     * 专业修改方法测试
     * 2020年5月29日10：44
     */
    @Test
    void  update(){
        Major major = new Major();
        major.setProfessionalId(1);
        major.setName("1f");
        major.setId(1);
        System.out.println(majorService.update(major));
      
    }

    /**
     * liang
     * 专业删除方法测试
     * 2020年5月29日10：44
     */
    @Test
    void  delete(){
        System.out.println(majorService.delete(1));
    }

    /**
     * liang
     * 专业查询方法测试
     * 2020年5月29日10：28
     */
    @Test
    void  get(){
        System.out.println(majorService.get(1).getName());
    }

    /**
     * liang
     * 成绩查询方法测试
     * 2020年5月29日23.30
     */
    @Test
    void  realAll(){
        System.out.println(majorService.readAll(null));
    }
}