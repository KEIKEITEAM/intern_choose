package com.lcvc.intern_choose.web.teacher;

import com.lcvc.intern_choose.model.Teacher;
import com.lcvc.intern_choose.model.base.Constant;
import com.lcvc.intern_choose.model.base.JsonCode;
import com.lcvc.intern_choose.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/teacher")
public class FrontTeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping(value = "/login")
    public Map<String, Object> login(String teacherNumber, String password, HttpSession session){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.ERROR.getValue());
        if(teacherService.login(teacherNumber, password)){//如果登录成功
            Teacher teacher=teacherService.get(teacherNumber);
            session.setAttribute("teacher",teacher);
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
        Teacher teacher=((Teacher) session.getAttribute("teacher"));
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, teacher);
        return map;
    }

    @GetMapping("/loginout")
    public Map<String, Object> logout(HttpSession session){
        Map<String, Object> map=new HashMap<String, Object>();
        session.removeAttribute("teacher");
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_MESSAGE, "成功注销用户");
        return map;
    }
}
