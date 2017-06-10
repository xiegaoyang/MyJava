package com.xgy.base.container;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by hadoop on 2017/4/18.
 */
public class MyLinkedList {


    public static void main(String[] args) {
        List<String> list = new LinkedList();
        list.add("1");
        list.add("12");
        list.add("123");
        list.add("1234");
        for (String str : list) {
            System.out.println(str);
        }
    }

}
