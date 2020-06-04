package com.lcvc.intern_choose.config;


import com.lcvc.intern_choose.interceptor.LoginForAdminInterceptor;
import com.lcvc.intern_choose.interceptor.LoginForStudentInterceptor;
import com.lcvc.intern_choose.interceptor.LoginForTeacherInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.LinkedList;

/**
 * 拦截器配置
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //后台管理账户登陆的拦截器
       registry.addInterceptor(loginForAdminInterceptor())
                .addPathPatterns("/api/backstage/**")//要拦截的路径
                .excludePathPatterns(new LinkedList<String>(){{  //不拦截的路径（一般指addPathPatterns中包含，但是不进行拦截的特例）
                    add("/api/backstage/login");
                    add("/api/backstage/logout");
                }});

        //学生账户登陆的拦截器
        registry.addInterceptor(loginForStudentInterceptor())
                .addPathPatterns("/api/student/**")//要拦截的路径
                .excludePathPatterns(new LinkedList<String>(){{//不拦截的路径（一般指addPathPatterns中包含，但是不进行拦截的特例）
                    add("/api/student/login");
                    add("/api/student/logout");
                }});

        //教师账户登陆的拦截器
        registry.addInterceptor(loginForTeacherInterceptor())
                .addPathPatterns("/api/teacher/**")//要拦截的路径
                .excludePathPatterns(new LinkedList<String>(){{//不拦截的路径（一般指addPathPatterns中包含，但是不进行拦截的特例）
                    add("/api/teacher/login");
                    add("/api/teacher/logout");
                }});
    }

    //创建拦截器对象，只有通过这里才能让拦截器中的依赖注入生效
    //后台登陆拦截器
    @Bean
    public HandlerInterceptor loginForAdminInterceptor() {
        return new LoginForAdminInterceptor();
    }
    //学生登录拦截器
    @Bean
    public HandlerInterceptor loginForStudentInterceptor() {
        return new LoginForStudentInterceptor();
    }
    //教师登陆拦截器
    @Bean
    public HandlerInterceptor loginForTeacherInterceptor() {
        return new LoginForTeacherInterceptor();
    }
}
