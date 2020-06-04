package com.lcvc.intern_choose.service;

import com.lcvc.intern_choose.model.Major;
import com.lcvc.intern_choose.model.base.PageObject;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface MajorService {
    /**
     * 根据ID查询该表数据
     * @param id
     * @return
     */
    Major get(@NotNull Integer id);

    /**
     * 获取该表全部数据
     * @return
     */
    List<Major> readAll();

    /**
     * 分页获取该表全部数据
     * @return
     */
    PageObject query (Integer page, Integer limit, Major major);

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
    boolean update(Major major);

    /**
     * 添加数据
     * @param
     * @return
     */
    boolean  save(Major major);

}
