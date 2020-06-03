package com.lcvc.intern_choose.web.backstage;

import com.lcvc.intern_choose.model.Professional;
import com.lcvc.intern_choose.model.Teacher;
import com.lcvc.intern_choose.model.base.Constant;
import com.lcvc.intern_choose.model.base.JsonCode;
import com.lcvc.intern_choose.service.TeacherService;
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
@RequestMapping("api/backstage/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;
    @GetMapping
    public Map<String, Object> readAll(){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, teacherService.readAll());
        return map;
    }

    @GetMapping("/{id}")
    public Map<String, Object> get(@PathVariable String id){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, teacherService.get(id));
        return map;
    }

    @Delete("/{id}")
    public Map<String, Object> delete(@PathVariable String id){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, teacherService.delete(id));
        return map;
    }

    @PostMapping
    public Map<String, Object> save(@Validated @RequestBody Teacher teacher){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, teacherService.save(teacher));
        return map;
    }

    @PutMapping
    public Map<String, Object> update(@RequestBody Teacher teacher){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, teacherService.update(teacher));
        return map;
    }

}
