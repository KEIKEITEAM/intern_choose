package com.lcvc.intern_choose.dao;

import com.lcvc.intern_choose.model.Grades;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradesDao extends IBaseDao<Grades>{

    /**
     * 查询所有Grades
     * @return 返回Grades对象集合
     */
    List<Grades> readAll();

    /**
     * 查询指定的Grades
     * @param id
     * @return 返回查询的结果，1表示成功，0表示失败
     */
    Grades get(@Param("id") Integer id);

    /**
     * 添加Grades的方法
     * @param grades
     * @return 返回添加的结果，1表示成功，0表示失败
     */
    int save(Grades grades);

    /**
     * 修改Grades的方法
     * @param grades
     * @return 返回修改的结果，1表示成功，0表示失败
     */
    int update(Grades grades);

    int delete(@Param("id") Integer id);
}
