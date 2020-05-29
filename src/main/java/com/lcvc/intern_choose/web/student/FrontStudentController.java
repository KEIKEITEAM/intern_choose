package com.lcvc.intern_choose.web.student;

import com.lcvc.intern_choose.model.Student;
import com.lcvc.intern_choose.model.base.Constant;
import com.lcvc.intern_choose.model.base.JsonCode;
import com.lcvc.intern_choose.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/student")
public class FrontStudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/login")
    public Map<String, Object> login(String studentNumber, String password, HttpSession session){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.ERROR.getValue());
        if(studentService.login(studentNumber, password)){//如果登录成功
            Student student=studentService.get(studentNumber);
            session.setAttribute("student",student);
            map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
            map.put(Constant.JSON_MESSAGE, "登录成功");
        }else{
            map.put(Constant.JSON_MESSAGE, "登录失败：用户名和密码错误");
        }
        return map;
    }

    @GetMapping
    public Map<String, Object> getLoginAdmin(HttpSession session){
        Map<String, Object> map=new HashMap<String, Object>();
        Student student=((Student) session.getAttribute("student"));
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, student);
        return map;
    }

    @GetMapping("/loginout")
    public Map<String, Object> logout(HttpSession session){
        Map<String, Object> map=new HashMap<String, Object>();
        session.removeAttribute("student");
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_MESSAGE, "成功注销用户");
        return map;
    }
}
