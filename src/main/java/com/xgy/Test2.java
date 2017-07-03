package com.xgy;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Created by gowild.cn on 2017/5/23.
 */
public class Test2 {
    public static void main(String[] args) {

        test14();

        int[] a = new int[5];
        for (int item : a) {
            System.out.println(item);
        }


//        Random ra = new Random();
//        System.out.println(ra.nextInt(1));

//        Byte a = 10;
//        int b = 10;
//        if (a.equals(b)) {
//            System.out.println("====");
//        }

//        Test2 test2 = new Test2();
//        test2.test4();

//        System.out.println(System.currentTimeMillis());

//        System.out.println(Test2.class.getSimpleName());

    }

    public void test4() {
//        System.currentTimeMillis();

        int id = 1;
        checkArgument(id > 0, "%s 表 id %s 必须大于0！", this, id);

    }

    public static void test3() {
        String str = "123";
        Integer value = 123;
        if (Integer.valueOf(str) == value) {
            System.out.println("equal");
        }
    }



    public static void test() {
        String reg = "[^0-9a-zA-Z\u4e00-\u9fa5]+";

//        String s1="我是正确测试数据aasdf2342343ASFASDF";
//        System.out.println(s1.replaceAll(reg,""));

        String s2 = "我是错误adf d.,a,d,o2aerafdea！@#！￥！@#！#kaodko。。d.a.测试数据@#！@#";
        System.out.println(s2.replaceAll(reg, ""));
    }

    public static void test2() {
        String str1 = null;
        String str2 = null;
        if (str1.equals(str2)) {
            System.out.println("equal");
        }
    }

    public static void test14() {

        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm:ss");
        Date currentDate;
        try {
//            currentDate = sdf.parse(sdf.format(new Date()));
            String date = "07-23 23:59:59";
            currentDate = sdf.parse(date);
            if((currentDate.after(sdf.parse("07-17 00:00:00")) && currentDate.before(sdf.parse("07-24 00:00:00")))){ //不是白班
                System.out.println("白天");
            }else {
                System.out.println("夜晚");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }


    @Override
    public String toString() {
        return "cm_category";
    }
}
