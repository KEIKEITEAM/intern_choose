package com.lcvc.intern_choose.service;

import com.lcvc.intern_choose.model.Classes;
import com.lcvc.intern_choose.model.base.PageObject;
import com.lcvc.intern_choose.model.query.ClassesQuery;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public interface ClassesServise {
    /**
     * 根据ID查询该表数据
     * @param id
     * @return
     */
    Classes get(@NotNull Integer id);

    /**
     * 获取该表全部数据
     * @return
     */
    List<Classes> readAll(ClassesQuery classesQuery);

    /**
     * 分页获取该表全部数据
     * @return
     */
    PageObject query (Integer page, Integer limit,ClassesQuery classesQuery);

    /**
     * 根据ID删除该表数据
     * @param id
     * @return
     */
    Boolean delete(@NotNull Integer id);

    /**
     * 根据ID修改该表数据
     * @param classes
     * @return
     */
    boolean update(Classes classes);

    /**
     * 添加数据
     * @param classes
     * @return
     */
    boolean  save(Classes classes);

}
