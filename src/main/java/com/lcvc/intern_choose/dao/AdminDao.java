package com.lcvc.intern_choose.dao;

import com.lcvc.intern_choose.model.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository//为了不让idea报错加上
public interface AdminDao extends IBaseDao<Admin>{
    /**
     * 处理数据库的登录方法
     * @param username 账户名
     * @param password 密码
     * @return 返回匹配的账户总数
     */
    int login(@Param(value = "username") String username, @Param(value = "password") String password);


    /**
     * 根据账户名查询某个用户的方法
     * @param username
     * @return
     */
    Admin getByUsername(@Param(value = "username") String username);
}
