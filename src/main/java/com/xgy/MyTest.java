package com.xgy.base;


import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

/**
 * Created by gowild.cn on 2017/5/26.
 */
public class MyTest {

    public static void test() {
        System.out.println("test");

        List<String> list = new ArrayList<String>();
        list.add("123");
        list.add("1234");
        list.add("12345");
        list.add("123456");

        for (String str : list) {
            System.out.println(str);
        }

        while (true) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello World");
        }

    }

    public static void test2() {
        List<String> list = new ArrayList<>();

    }

    public static void main(String[] args) {

//        System.out.println("Hello World");

//        test2();

        String str = "A";
        str.toLowerCase();

    }



}
