package com.lcvc.intern_choose.web.backstage;

import com.lcvc.intern_choose.model.TeacherProfessionalGrade;
import com.lcvc.intern_choose.model.base.Constant;
import com.lcvc.intern_choose.model.base.JsonCode;
import com.lcvc.intern_choose.model.query.TeacherProfessionalGradeQuery;
import com.lcvc.intern_choose.service.TeacherProfessionalGradeService;
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
@RequestMapping("api/backstage/teacherProfessionalGrade")
public class TeacherProfessionalGradeController {

    @Autowired
    private TeacherProfessionalGradeService teacherProfessionalGradeService;
    @GetMapping
    public Map<String, Object> readAll(Integer page, Integer limit, TeacherProfessionalGradeQuery teacherProfessionalGradeQuery){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, teacherProfessionalGradeService.query(page,limit,teacherProfessionalGradeQuery));
        return map;
    }

    @GetMapping("/{id}")
    public Map<String, Object> get(@PathVariable Integer id){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, teacherProfessionalGradeService.get(id));
        return map;
    }

    @Delete("/{id}")
    public Map<String, Object> delete(@PathVariable Integer id){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, teacherProfessionalGradeService.delete(id));
        return map;
    }

    @PostMapping
    public Map<String, Object> save(@Validated @RequestBody TeacherProfessionalGrade teacherProfessionalGrade){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, teacherProfessionalGradeService.save(teacherProfessionalGrade));
        return map;
    }

    @PutMapping
    public Map<String, Object> update(@RequestBody TeacherProfessionalGrade teacherProfessionalGrade){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, teacherProfessionalGradeService.update(teacherProfessionalGrade));
        return map;
    }
}
