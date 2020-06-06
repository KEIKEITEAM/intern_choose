package com.lcvc.intern_choose.dao;

import com.lcvc.intern_choose.model.Admin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AdminDaoTest {

    @Autowired
    private AdminDao adminDao;

    /**
     * ZF
     * 年级添加方法测试
     * 2020年5月29日10：44
     */
    @Test
    void login() {
        //调用dao与数据库进行数据校验
        int admin = adminDao.login("admin", "123456");

        if (admin != 0){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }
    }

    @Test
    void getByUsername() {
        System.out.println(adminDao.getByUsername("admin"));
    }

    @Test
    void get(){
        System.out.println(adminDao.get(2).getPassword());
    }

    @Test
    void update(){
        Admin admin=new Admin();
        admin.setUsername("123");
        System.out.println(adminDao.update(admin));
    }
    @Test
    void updatePassword(){
        Admin admin=new Admin();
        admin.setPassword("123");
        admin.setUsername("123");
        admin.setName("123123");
        admin.setId(1);
        System.out.println(adminDao.update(admin));
    }
}