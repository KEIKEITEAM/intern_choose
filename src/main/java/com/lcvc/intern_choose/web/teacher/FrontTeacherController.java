package com.lcvc.intern_choose.web.teacher;

import com.lcvc.intern_choose.model.Teacher;
import com.lcvc.intern_choose.model.base.Constant;
import com.lcvc.intern_choose.model.base.JsonCode;
import com.lcvc.intern_choose.model.form.TeacherPasswordForm;
import com.lcvc.intern_choose.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/logout")
    public Map<String, Object> logout(HttpSession session){
        Map<String, Object> map=new HashMap<String, Object>();
        session.removeAttribute("teacher");
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_MESSAGE, "成功注销用户");
        return map;
    }

    @GetMapping("/getStudent")
    public Map<String, Object> getStudent(Integer page, Integer limit,HttpSession session){
        Map<String, Object> map=new HashMap<String, Object>();
        Teacher teacher=((Teacher) session.getAttribute("teacher"));
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, teacherService.getByTeacherNumber(teacher.getTeacherNumber(),page,limit));
        return map;
    }

    @PutMapping("/updatePassword")
    public Map<String, Object> updatePassword(@Validated @RequestBody TeacherPasswordForm teacherPasswordForm, HttpSession session){
        Map<String, Object> map=new HashMap<String, Object>();
        Teacher teacher=((Teacher) session.getAttribute("teacher"));
        Boolean status=teacherService.updatePassword(teacherPasswordForm,teacher.getTeacherNumber());
        if (status){
            map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
            map.put(Constant.JSON_MESSAGE, "修改成功，请重新登录");
            logout(session);
        }else {
            map.put(Constant.JSON_CODE, JsonCode.ERROR.getValue());
            map.put(Constant.JSON_MESSAGE, "修改失败");
        }
        return map;
    }
}
