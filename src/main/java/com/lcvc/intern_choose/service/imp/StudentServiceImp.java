package com.lcvc.intern_choose.service.imp;

import com.lcvc.intern_choose.dao.StudentDao;
import com.lcvc.intern_choose.model.Student;
import com.lcvc.intern_choose.model.exception.MyWebException;
import com.lcvc.intern_choose.service.StudentService;
import com.lcvc.intern_choose.util.SHA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentDao studentDao;

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

    public Student get(String studentNumber){
        return studentDao.get(studentNumber);
    }

    @Override
    public List<Student> readAll() {
        ArrayList<Student> list = new ArrayList<>();
        for (Student student : studentDao.readAll()) {
            list.add(student);
        }
        return list.size() != 0 ? list : null;
    }

    @Override
    public Boolean delete(@NotNull String studentNumber) {
        int k = studentDao.delete(studentNumber);
        return k > 0 ? true : false;
    }

    @Override
    public boolean update(Student Student) {
        int k = studentDao.update(Student);
        return k > 0 ? true : false;
    }

    @Override
    public boolean save(Student Student) {
        int k = studentDao.save(Student);
        return k > 0 ? true : false;
    }

}
