package com.lcvc.intern_choose.service.imp;

import com.lcvc.intern_choose.dao.AdminDao;
import com.lcvc.intern_choose.model.Admin;
import com.lcvc.intern_choose.model.exception.MyServiceException;
import com.lcvc.intern_choose.model.exception.MyWebException;
import com.lcvc.intern_choose.model.form.AdminPasswordForm;
import com.lcvc.intern_choose.service.AdminService;
import com.lcvc.intern_choose.util.SHA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class AdminServiceImp implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin get(Integer id){
        Admin admin=null;
        if(id!=null){
            admin=adminDao.get(id);
        }
        return admin;
    }


    @Override
    public boolean login(String username, String password){
        boolean judge=false;
        if(StringUtils.isEmpty(username)){
            throw new MyWebException("登陆失败：账户名不能为空");
        }else  if(StringUtils.isEmpty(password)){
            throw new MyWebException("登陆失败：密码不能为空");
        }else{
            if(adminDao.login(username, SHA.getResult(password))==1){
                judge=true;
            }
        }
        return judge;
    }

    @Override
    public Admin getByUsername(String username) {
        Admin admin=adminDao.getByUsername(username);
        return  admin!=null?admin:null;
    }

    @Override
    public Boolean updatePassword(AdminPasswordForm adminPasswordForm,Integer id) {
        Admin admin=adminDao.get(id);
        if (!SHA.getResult(adminPasswordForm.getPassword()).equals(admin.getPassword())){
            throw new MyServiceException("与原密码不一致");
        }
        if (!adminPasswordForm.getNewPassword().equals(adminPasswordForm.getConfirmPassword())){
            throw new MyServiceException("新密码与确认密码不一致");
        }
        Admin newadmin=new Admin();
        newadmin.setPassword(SHA.getResult(adminPasswordForm.getNewPassword()));
        newadmin.setId(id);
        int k=adminDao.update(newadmin);
        return k>0;
    }

    @Override
    public Boolean update(Admin admin) {
        return null;
    }
}
