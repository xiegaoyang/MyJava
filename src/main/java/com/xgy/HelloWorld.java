package com.xgy.base;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by gowild.cn on 2017/5/12.
 */
public class HelloWorld {

    public static void test(int a) {
        System.out.println("a = " + a);

        Thread.getAllStackTraces();
        System.out.println(Thread.getAllStackTraces());

    }

    public static void test2(String str) {
        System.out.println(str);
    }


    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
//        long time = 1495091235929;
        long time = System.currentTimeMillis();
        calendar.setTime(new Date(time));
        int hour = calendar.get(Calendar.HOUR);

        int minute = calendar.get(Calendar.MINUTE);

        System.out.println(hour);
        System.out.println(minute);

//        for (int i = 0; i < 3; i++) {
//            HelloWorld.test(101);
//            HelloWorld.test2("xgy");
//        }

    }

}
