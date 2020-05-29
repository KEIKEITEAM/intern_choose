package com.lcvc.intern_choose.service.imp;

import com.lcvc.intern_choose.dao.StudentDao;
import com.lcvc.intern_choose.model.Student;
import com.lcvc.intern_choose.model.exception.MyWebException;
import com.lcvc.intern_choose.service.StudentService;
import com.lcvc.intern_choose.util.SHA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentDao studentDao;

    public Student get(String id){
        Student teacher=studentDao.get(id);
        return teacher;
    }


    public boolean login(String studentNumber, String password){
        boolean judge=false;
        if(StringUtils.isEmpty(studentNumber)){
            throw new MyWebException("登陆失败：学号不能为空");
        }else  if(StringUtils.isEmpty(password)){
            throw new MyWebException("登陆失败：密码不能为空");
        }else{
            if(studentDao.login(studentNumber, SHA.getResult(password))==1){
                judge=true;
            }
        }
        return judge;
    }

}
