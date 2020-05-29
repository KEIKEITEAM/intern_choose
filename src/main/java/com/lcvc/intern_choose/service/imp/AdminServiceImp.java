package com.lcvc.intern_choose.service.imp;

import com.lcvc.intern_choose.dao.AdminDao;
import com.lcvc.intern_choose.model.Admin;
import com.lcvc.intern_choose.model.exception.MyWebException;
import com.lcvc.intern_choose.service.AdminService;
import com.lcvc.intern_choose.util.SHA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class AdminServiceImp implements AdminService {

    @Autowired
    private AdminDao adminDao;

    public Admin get(Integer id){
        Admin admin=null;
        if(id!=null){
            admin=adminDao.get(id);
        }
        return admin;
    }


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

    public Admin getByUsername(String username) {
        Admin admin=adminDao.getByUsername(username);
        if (admin!=null)
            return admin;
        return  null;
    }
}
