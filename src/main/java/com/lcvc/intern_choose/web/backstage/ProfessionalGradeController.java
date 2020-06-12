package com.lcvc.intern_choose.web.backstage;

import com.lcvc.intern_choose.model.ProfessionalGrade;
import com.lcvc.intern_choose.model.base.Constant;
import com.lcvc.intern_choose.model.base.JsonCode;
import com.lcvc.intern_choose.model.query.ProfessionalGradeQuery;
import com.lcvc.intern_choose.service.ProfessionalGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liang
 */
@RestController
@RequestMapping("api/backstage/professionalGrade")
public class ProfessionalGradeController {

    @Autowired
    private ProfessionalGradeService professionalGradeService;

    @GetMapping
    public Map<String, Object> readAll(Integer page, Integer limit, ProfessionalGradeQuery professionalGradeQuery){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, professionalGradeService.query(page,limit,professionalGradeQuery));
        return map;
    }

    @GetMapping("/{id}")
    public Map<String, Object> get(@PathVariable Integer id){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, professionalGradeService.get(id));
        return map;
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> delete(@PathVariable Integer id){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, professionalGradeService.delete(id));
        return map;
    }

    @PostMapping
    public Map<String, Object> save(@Validated @RequestBody ProfessionalGrade professionalGrade){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, professionalGradeService.save(professionalGrade));
        return map;
    }

    @PutMapping
    public Map<String, Object> update(@RequestBody ProfessionalGrade professionalGrade) throws ParseException {
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, professionalGradeService.update(professionalGrade));
        return map;
    }
}
