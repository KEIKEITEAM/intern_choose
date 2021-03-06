package com.lcvc.intern_choose.web.teacher;

import com.lcvc.intern_choose.model.Teacher;
import com.lcvc.intern_choose.model.base.Constant;
import com.lcvc.intern_choose.model.base.JsonCode;
import com.lcvc.intern_choose.model.form.TeacherPasswordForm;
import com.lcvc.intern_choose.service.ProfessionalGradeService;
import com.lcvc.intern_choose.service.TeacherService;
import com.lcvc.intern_choose.service.TeacherStudentService;
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
    @Autowired
    private ProfessionalGradeService professionalGradeService;
    @Autowired
    private TeacherStudentService teacherStudentService;
    @GetMapping("/login")
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
    public Map<String, Object> getStudent(Integer professionalGradeId,Integer page,Integer limit,HttpSession session){
        Map<String, Object> map=new HashMap<String, Object>();
        Teacher teacher=((Teacher) session.getAttribute("teacher"));
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, teacherStudentService.getByTeacherNumber(teacher.getTeacherNumber(),professionalGradeId,page,limit));
        return map;
    }

    @GetMapping("/getProfessionalGrade")
    public Map<String, Object> getTeacherGrade(HttpSession session){
        Map<String, Object> map=new HashMap<String, Object>();
        Teacher teacher=((Teacher) session.getAttribute("teacher"));
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, professionalGradeService.getProfessionalGradeByTeacherNumber(teacher.getTeacherNumber()));
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

    @PutMapping
    public Map<String, Object> update(@RequestBody Teacher teacher, HttpSession session){
        Map<String, Object> map=new HashMap<String, Object>();
        Teacher teacherSession=((Teacher) session.getAttribute("teacher"));
        Teacher newTeacher=new Teacher();
        newTeacher.setTeacherNumber(teacherSession.getTeacherNumber());
        newTeacher.setTel(teacher.getTel());
        newTeacher.setQq(teacher.getQq());
        Boolean status=teacherService.update(newTeacher);
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA,status);
        return map;
    }
}
