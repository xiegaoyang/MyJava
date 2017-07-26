package com.xgy.base.string;


public class MyString {


    public static void test() {

        String a = "Programming";
        String b = new String("Programming");
        String c = "Program" + "ming";

        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(a.intern() == b.intern());

    }


    public static void main(String[] args) {

        test();


    }


}






