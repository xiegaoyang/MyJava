package com.xgy.base.system;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by gowild.cn on 2017/6/29.
 */
public class MyDate {

    public static void main(String[] args) {
        System.out.println(MyDate.getCurrentTime());

        System.out.println((new Date())());

    }

    public static String getCurrentTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String curDate = df.format(new Date());
        curDate = curDate.substring(0, 8) + "20";
        return curDate;
    }

}
