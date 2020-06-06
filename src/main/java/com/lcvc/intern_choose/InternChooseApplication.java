package com.lcvc.intern_choose;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 张峰
 */
@SpringBootApplication
@MapperScan("com.lcvc.intern_choose.dao")
public class InternChooseApplication {

    public static void main(String[] args) {
        SpringApplication.run(InternChooseApplication.class, args); 
    }

}
