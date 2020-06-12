package com.lcvc.intern_choose.dao;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author KEI
 * 2020/6/12 9:40
 */
@SpringBootTest
public class test {
    @Test
    void tes() {

        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        List<String> list3 = new ArrayList<String>();
        list1.add("1");
        list1.add("2");
        list1.add("3");

        list2.add("2");
        list2.add("3");

        list1.retainAll(list2);

        System.out.println(list1);
    }
}
