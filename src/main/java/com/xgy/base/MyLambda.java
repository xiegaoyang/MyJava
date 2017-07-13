package com.xgy.base;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class MyLambda {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        Collections.sort(names, new Comparator<String>() {

            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });

        //java 1.8
//		Collections.sort(names, (String a, String b) -> {
//			returnb.compareTo(a);
//			});

        System.out.println(names.toString());

    }

}


