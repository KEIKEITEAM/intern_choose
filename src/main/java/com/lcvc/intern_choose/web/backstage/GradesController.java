package com.lcvc.intern_choose.web.backstage;


import com.lcvc.intern_choose.model.Grades;
import com.lcvc.intern_choose.model.base.Constant;
import com.lcvc.intern_choose.model.base.JsonCode;
import com.lcvc.intern_choose.service.GradesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/backstage/grade")
public class GradesController {

    @Autowired
    private GradesService gradesService;

    @GetMapping
    public Map<String, Object> query(Integer page, Integer limit){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, gradesService.query(page,limit,null));
        return map;
    }

    @GetMapping("/{id}")
    public Map<String, Object> get(@PathVariable Integer id){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, gradesService.get(id));
        return map;
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> delete(@PathVariable Integer id){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, gradesService.delete(id));
        return map;
    }

    @PostMapping
    public Map<String, Object> save(@Validated @RequestBody Grades grades){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, gradesService.save(grades));
        return map;
    }

    @PutMapping
    public Map<String, Object> update(@RequestBody Grades grades){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, gradesService.update(grades));
        return map;
    }


}
