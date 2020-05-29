package com.lcvc.intern_choose.dao;

import com.lcvc.intern_choose.model.Grades;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GradesDaoTest {
  @Autowired
  private GradesDao gradesDao;

    /**
     * liang
     * 成绩查询方法测试
     * 2020年5月29日15：44
     */
    @Test
    void readAll() {
        for (Grades grades : gradesDao.readAll()) {
            System.out.println(grades);
        }
    }

    /**
     * liang
     * 查询方法测试
     * 2020年5月29日15：44
     */
    @Test
    void get() {

        System.out.println(gradesDao.get(1));
    }

    /**
     * liang
     * 成绩添加方法测试
     * 2020年5月29日15：44
     */
    @Test
    void save() {
        Grades grades = new Grades();
        grades.setId(5);
        grades.setName("zhangsan");
        System.out.println(gradesDao.save(grades));
    }

    /**
     * liang
     * 成绩修改方法测试
     * 2020年5月29日15：44
     */
    @Test
    void update() {
        Grades grades = new Grades();
        grades.setId(5);
        grades.setName("zhangsan1");
        System.out.println(gradesDao.update(grades));
    }

    /**
     * liang
     * 成绩删除方法测试
     * 2020年5月29日15：44
     */
    @Test
    void delete() {
        System.out.println(gradesDao.delete(5));
    }
}