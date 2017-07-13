package com.xgy.base;


import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MySystem {

    public static void Time() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();// 取当前日期。
        System.out.println("Today is:" + format.format(cal.getTime()));
    }

    public static void main(String[] args) {

        // TODO Auto-generated method stub
        System.out.println("Hello World");

        SecurityManager sm = new SecurityManager();
        System.setSecurityManager(sm);


        System.exit(0);
        //Runtime.getRuntime().exit(0);
    }

}
