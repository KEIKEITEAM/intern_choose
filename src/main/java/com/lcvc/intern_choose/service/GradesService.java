package com.lcvc.intern_choose.service;

import com.lcvc.intern_choose.model.Classes;
import com.lcvc.intern_choose.model.Grades;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface GradesService {
    /**
     * 根据ID查询该表数据
     * @param id
     * @return
     */
    Grades get(@NotNull Integer id);

    /**
     * 获取该表全部数据
     * @return
     */
    List<Grades> readAll();

    /**
     * 根据ID删除该表数据
     * @param id
     * @return
     */
    Boolean delete(@NotNull Integer id);

    /**
     * 根据ID修改该表数据
     * @param
     * @return
     */
    boolean update(Grades grades);

    /**
     * 添加数据
     * @param
     * @return
     */
    boolean  save(Grades grades);
}
