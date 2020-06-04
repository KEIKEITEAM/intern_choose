package com.lcvc.intern_choose.web.backstage;


import com.lcvc.intern_choose.model.Classes;
import com.lcvc.intern_choose.model.base.Constant;
import com.lcvc.intern_choose.model.base.JsonCode;
import com.lcvc.intern_choose.model.base.PageObject;
import com.lcvc.intern_choose.service.ClassesServise;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/backstage/class")
public class ClassesController {
    @Autowired
    private ClassesServise classesServise;

    /**
     * 查询并分页
     * @param page 当前页
     * @param limit 当前页数量大小
     * @return
     */
    @GetMapping
    public Map<String, Object> query(Integer page, Integer limit){
        Map<String, Object> map=new HashMap<String, Object>();
        PageObject pageObject =classesServise.query(page,limit,null);
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, pageObject);
        return map;
    }

    @GetMapping("/{id}")
    public Map<String, Object> get(@PathVariable Integer id){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, classesServise.get(id));
        return map;
    }

    @Delete("/{id}")
    public Map<String, Object> delete(@PathVariable Integer id){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, classesServise.delete(id));
        return map;
    }

    @PostMapping
    public Map<String, Object> save(@Validated @RequestBody Classes classes){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, classesServise.save(classes));
        return map;
    }

    @PutMapping
    public Map<String, Object> update(@RequestBody Classes classes){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, classesServise.update(classes));
        return map;
    }


}
