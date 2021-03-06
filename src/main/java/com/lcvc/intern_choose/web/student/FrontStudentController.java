package com.lcvc.intern_choose.web.student;

import com.lcvc.intern_choose.model.Student;
import com.lcvc.intern_choose.model.base.Constant;
import com.lcvc.intern_choose.model.base.JsonCode;
import com.lcvc.intern_choose.model.form.StudentPasswordForm;
import com.lcvc.intern_choose.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
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

    @GetMapping("/logout")
    public Map<String, Object> logout(HttpSession session){
        Map<String, Object> map=new HashMap<String, Object>();
        session.removeAttribute("student");
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_MESSAGE, "成功注销用户");
        return map;
    }

    @PostMapping("/choose/{teacherNumber}")
    public Map<String, Object> choose(@PathVariable  String teacherNumber, HttpSession session) throws ParseException {
        Map<String, Object> map=new HashMap<String, Object>();
        Student student=((Student) session.getAttribute("student"));
        studentService.choose(student.getStudentNumber(),teacherNumber);
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_MESSAGE, "选择成功");
        return map;
    }

    @GetMapping("/getTeacher")
    public Map<String, Object> getTeacher(HttpSession session){
        Map<String, Object> map=new HashMap<String, Object>();
        Student student=((Student) session.getAttribute("student"));
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, studentService.getTeacher(student.getStudentNumber()));
        return map;
    }

    @GetMapping("/getAvailableTeacher")
    public Map<String, Object> getAvailableTeacher(HttpSession session){
        Map<String, Object> map=new HashMap<String, Object>();
        Student student=((Student) session.getAttribute("student"));
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, studentService.getAvailableTeacher(student.getClasses().getId()));
        return map;
    }

    @PutMapping("/updatePassword")
    public Map<String, Object> updatePassword(@Validated  @RequestBody StudentPasswordForm studentPasswordForm, HttpSession session){
        Map<String, Object> map=new HashMap<String, Object>();
        Student student=((Student) session.getAttribute("student"));
        Boolean status=studentService.updatePassword(studentPasswordForm,student.getStudentNumber());
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
    public Map<String, Object> update(@RequestBody Student student, HttpSession session){
        Map<String, Object> map=new HashMap<String, Object>();
        Student studentSession=((Student) session.getAttribute("student"));
        Student newStudent=new Student();
        newStudent.setQq(student.getQq());
        newStudent.setTel(student.getTel());
        newStudent.setStudentNumber(studentSession.getStudentNumber());
        Boolean status=studentService.update(newStudent);
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA,status);
        return map;
    }
}
