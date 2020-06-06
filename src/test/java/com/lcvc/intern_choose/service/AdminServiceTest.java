package com.lcvc.intern_choose.service;

import com.lcvc.intern_choose.model.form.AdminPasswordForm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author KEI
 * 2020/6/6 13:48
 */
@SpringBootTest
public class AdminServiceTest {
    @Autowired
    private AdminService adminService;
    @Test
    void updatePassword(){
        AdminPasswordForm adminPasswordForm=new AdminPasswordForm();
        adminPasswordForm.setPassword("1234567890123456");
        adminPasswordForm.setNewPassword("123456");
        adminPasswordForm.setConfirmPassword("123456");
        System.out.println( adminService.updatePassword(adminPasswordForm,1));
    }
}
