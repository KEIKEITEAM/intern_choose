package com.lcvc.intern_choose.web.backstage;

import com.lcvc.intern_choose.model.Student;
import com.lcvc.intern_choose.model.base.Constant;
import com.lcvc.intern_choose.model.base.JsonCode;
import com.lcvc.intern_choose.model.query.StudentQuery;
import com.lcvc.intern_choose.service.StudentService;
import com.lcvc.intern_choose.service.TeacherStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liang
 */
@RestController
@RequestMapping("api/backstage/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherStudentService teacherStudentService;

    @GetMapping
    public Map<String, Object> readAll(Integer page, Integer limit, StudentQuery studentQuery) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, studentService.query(page,limit,studentQuery));
        return map;
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> delete(@PathVariable String id) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, studentService.delete(id));
        return map;
    }

    @PostMapping
    public Map<String, Object> save(@Validated @RequestBody Student student) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, studentService.save(student));
        return map;
    }

    @PutMapping
    public Map<String, Object> update(@Validated @RequestBody Student student) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, studentService.update(student));
        return map;
    }

    @GetMapping("/{id}")
    public Map<String, Object> get(@PathVariable String id) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, studentService.get(id));
        return map;
    }

    /**
     * 获取没有选择实习老师的学生集合
     * @param page
     * @param limit
     * @param studentQuery
     * @return
     */
    @GetMapping("/getNotChooseStudent")
    public Map<String, Object> getNotChooseStudent(Integer page,Integer limit,StudentQuery studentQuery) {
        Map<String, Object> map = new HashMap<String,Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, studentService.query(page,limit,studentQuery));
        return map;
    }

    /**
     * 获取开放选择权限的实习学生
     * （major和professionalGrade open为true）
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/getOpenStudent")
    public Map<String, Object> getOpenStudent(Integer page,Integer limit) {
        Map<String, Object> map = new HashMap<String,Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, studentService.getOpenStudent(page,limit));
        return map;
    }

}
