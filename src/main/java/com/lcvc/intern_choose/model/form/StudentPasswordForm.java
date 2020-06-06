package com.lcvc.intern_choose.model.form;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @Author KEI
 * 2020/6/5 16:17
 */
public class StudentPasswordForm {
    @NotNull(message = "原密码不能为空")
    private String password;
    @NotNull(message = "新密码不能为空")
    @Length(min = 6,max = 16,message = "密码长度要求在6到16之间")
    private String newPassword;
    @NotNull(message = "确认密码不能为空")
    private String confirmPassword;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
