package com.xgy.base;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 2017/9/17.
 */

public class MyJava {
    public static void main(String[] args) {
        System.out.println("Hello World");

        List<String> list = new ArrayList<>();
        list.add("12");
        list.add("1234");
        list.add("1232");
        list.add("123222");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}
