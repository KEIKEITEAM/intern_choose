package com.lcvc.intern_choose.dao;

import com.lcvc.intern_choose.model.Major;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MajorDao extends IBaseDao<Major>{

    List<Major> readAll();

    int save(Major major);

    int get(@Param("id")Integer id);

    int update(Major major);

    int delete(@Param("id")Integer id);
}
