package com.lcvc.intern_choose.web.backstage;

import com.lcvc.intern_choose.model.Admin;
import com.lcvc.intern_choose.model.base.Constant;
import com.lcvc.intern_choose.model.base.JsonCode;
import com.lcvc.intern_choose.service.imp.AdminServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/backstage")
public class AdminController {
    @Autowired
    private AdminServiceImp adminService;

    @GetMapping(value = "/login")
    public Map<String, Object> login(String username, String password, HttpSession session){
        Map<String, Object> map=new HashMap<String, Object>();
        map.put(Constant.JSON_CODE, JsonCode.ERROR.getValue());
        if(adminService.login(username, password)){//如果登录成功
            Admin admin=adminService.getByUsername(username);
            session.setAttribute("admin",admin);
            map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
            map.put(Constant.JSON_MESSAGE, "登录成功");
            //map.put(Constant.JSON_DATA,admin.getUsername());//将账户名值传递到前端先存储，供后端交互
        }else{
            map.put(Constant.JSON_MESSAGE, "登录失败：用户名和密码错误");
        }
        System.out.println("46444");
        return map;
    }

    @GetMapping
    public Map<String, Object> getLoginAdmin(HttpSession session){
        Map<String, Object> map=new HashMap<String, Object>();
        Admin admin=((Admin) session.getAttribute("admin"));
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_DATA, admin);
        return map;
    }

    @GetMapping("/loginout")
    public Map<String, Object> logout(HttpSession session){
        Map<String, Object> map=new HashMap<String, Object>();
        session.removeAttribute("admin");
        map.put(Constant.JSON_CODE, JsonCode.SUCCESS.getValue());
        map.put(Constant.JSON_MESSAGE, "成功注销用户");
        return map;
    }
}
