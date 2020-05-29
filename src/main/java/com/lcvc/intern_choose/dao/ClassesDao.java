package com.lcvc.intern_choose.dao;

import com.lcvc.intern_choose.model.Classes;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassesDao extends IBaseDao<Classes>{

    /**
     * 用于查询所有并返回所有的Classes方法
     * @return  返回查询到的Classes集合
     */
    List<Classes> readAll();

    /**
     * 查询指定的Classes
     * @param id Classes id
     * @return 返回指定的Classes
     */
    Classes get(@Param("id") Integer id);

    /**
     * 添加Classes方法
     * @param classes
     * @return 返回1表示添加成功，0表示失败
     */
    int save(Classes classes);

    /**
     * 修改Classes方法
     * @param classes
     * @return  返回1表示修改成功，0表示失败
     */
    int update(Classes classes);

    /**
     * 删除Classes方法
     * @param id
     * @return 返回1表示删除成功，0表示失败
     */
    int delete(@Param("id")Integer id);





}
