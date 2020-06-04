package com.lcvc.intern_choose.web.backstage;

import com.lcvc.intern_choose.model.TeacherStudent;
import com.lcvc.intern_choose.model.base.Constant;
import com.lcvc.intern_choose.model.base.JsonCode;
import com.lcvc.intern_choose.model.query.TeacherStudentQuery;
import com.lcvc.intern_choose.service.TeacherStudentService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liang
 */
@RestController
@RequestMapping("api/backstage/teacherStudent")
public class TeacherStudentController {
    
    @Autowired
    private TeacherStudentService teacherStudentService;
    
    @GetMapping
    public Map<String, Object> readAll(Integer page, Integer limit, TeacherStudentQuery teacherStudentQuery){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, teacherStudentService.query(page,limit,teacherStudentQuery));
        return map;
    }

    @GetMapping("/{id}")
    public Map<String, Object> get(@PathVariable Integer id){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, teacherStudentService.get(id));
        return map;
    }

    @Delete("/{id}")
    public Map<String, Object> delete(@PathVariable Integer id){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, teacherStudentService.delete(id));
        return map;
    }

    @PostMapping
    public Map<String, Object> save(@Validated @RequestBody TeacherStudent teacherStudent){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, teacherStudentService.save(teacherStudent));
        return map;
    }

    @PutMapping
    public Map<String, Object> update(@RequestBody TeacherStudent teacherStudent){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, teacherStudentService.update(teacherStudent));
        return map;
    }
}
