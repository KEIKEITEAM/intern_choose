package com.lcvc.intern_choose.service;

import com.lcvc.intern_choose.model.Admin;
import com.lcvc.intern_choose.model.form.AdminPasswordForm;
import org.springframework.stereotype.Service;





/**
 * @author 张峰
 */
@Service
public interface AdminService {


    Admin get(Integer id);

    /**
     * 登录方法
     *
     * @param username 账户名，不能为空
     * @param password 密码，不能为空
     * @return null表示登录失败
     */
    boolean login(String username, String password);

    Admin getByUsername(String username);

    /**
     * 修改密码
     * @param adminPasswordForm
     * @return
     */
    Boolean updatePassword(AdminPasswordForm adminPasswordForm,Integer id);

    /**
     * 修改用户信息
     * @param admin
     * @return
     */
    Boolean update(Admin admin);
}
