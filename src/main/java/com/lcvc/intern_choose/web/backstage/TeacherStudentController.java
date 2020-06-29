package com.lcvc.intern_choose.web.backstage;

import com.lcvc.intern_choose.model.TeacherStudent;
import com.lcvc.intern_choose.model.base.Constant;
import com.lcvc.intern_choose.model.base.JsonCode;
import com.lcvc.intern_choose.model.query.TeacherStudentQuery;
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
@RequestMapping("api/backstage/teacherStudent")
public class TeacherStudentController {

    @Autowired
    private TeacherStudentService teacherStudentService;

    @GetMapping
    public Map<String, Object> readAll(Integer page, Integer limit, TeacherStudentQuery teacherStudentQuery) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, teacherStudentService.query(page, limit, teacherStudentQuery));
        return map;
    }

    @GetMapping("/{id}")
    public Map<String, Object> get(@PathVariable Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, teacherStudentService.get(id));
        return map;
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> delete(@PathVariable Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, teacherStudentService.delete(id));
        return map;
    }

    @PostMapping
    public Map<String, Object> save(@Validated @RequestBody TeacherStudent teacherStudent) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, teacherStudentService.save(teacherStudent));
        return map;
    }

    @PutMapping
    public Map<String, Object> update(@RequestBody TeacherStudent teacherStudent) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, teacherStudentService.update(teacherStudent));
        return map;
    }

    /**
     * 批量添加
     *
     * @param studentNumbers
     * @param tpgId
     * @return
     */
    @PostMapping("/batchAdd")
    public Map<String, Object> batchAdd(@RequestBody String studentNumbers,Integer tpgId) {
        Map<String, Object> map = new HashMap<String, Object>();
        int sum=teacherStudentService.batchAdd(studentNumbers, tpgId);
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA,"已批量添加"+sum+"条记录");
        return map;
    }

    /**
     * 随机分配未选择实习老师的学生
     *
     * @param tpgId
     * @return 成功记录数
     */
    @PostMapping("/randomChoose/{tpgId}")
    public Map<String, Object> randomChoose(@PathVariable Integer tpgId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_MESSAGE, teacherStudentService.randomChooseStudent(tpgId));
        return map;
    }

}
