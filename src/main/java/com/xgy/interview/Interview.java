package com.xgy.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 2017/7/18.
 */
public class Interview {

    public static void test1() {
        int a = 6, b = 4, d = 8;
        String c = "abc";
        System.out.println(a + b + c + d); //10abc8

        char e = 80;
        char f = '\n';
        int g = (int) 12.88;
//        byte h = 130;
    }

    public static void change(String str, List<String> list) {
        str = "456";
        list.clear();
        list.add(str);
    }

    public static void test2() {
        List<String> list = new ArrayList<>();
        String str = "123";
        list.add(str);
        change(str, list);
        System.out.println(str + ", " + list.get(0));
    }

    public static void test3() {
        boolean flag = 0.1 * 3 == 0.3;
        System.out.println(flag);
    }

    public static void main(String[] args) {
//        Interview.test1();
//        Interview.test2();
        Interview.test3();

    }

}
