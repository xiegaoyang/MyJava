package com.xgy.base;

/**
 * Created by gowild.cn on 2017/5/23.
 */
public class Test2 {
    public static void main(String[] args) {

        test3();

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

        String s2="我是错误adf d.,a,d,o2aerafdea！@#！￥！@#！#kaodko。。d.a.测试数据@#！@#";
        System.out.println(s2.replaceAll(reg,""));
    }

    public static void test2() {
        String str1 = null;
        String str2 = null;
        if (str1.equals(str2)) {
            System.out.println("equal");
        }
    }

}
