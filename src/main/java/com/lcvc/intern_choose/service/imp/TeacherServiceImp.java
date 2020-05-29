package com.lcvc.intern_choose.service.imp;

import com.lcvc.intern_choose.dao.TeacherDao;
import com.lcvc.intern_choose.model.Teacher;
import com.lcvc.intern_choose.model.exception.MyWebException;
import com.lcvc.intern_choose.service.TeacherService;
import com.lcvc.intern_choose.util.SHA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class TeacherServiceImp implements TeacherService {

    @Autowired
    private TeacherDao teacherDao;

    public Teacher get(String id){
        Teacher teacher=teacherDao.get(id);
        return teacher;
    }


    public boolean login(String teacherNumber, String password){
        boolean judge=false;
        if(StringUtils.isEmpty(teacherNumber)){
            throw new MyWebException("登陆失败：工号不能为空");
        }else  if(StringUtils.isEmpty(password)){
            throw new MyWebException("登陆失败：密码不能为空");
        }else{
            if(teacherDao.login(teacherNumber, SHA.getResult(password))==1){
                judge=true;
            }
        }
        return judge;
    }

}
