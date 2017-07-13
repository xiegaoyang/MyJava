package com.xgy.base;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Calendar;


public class MyRTTI {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //TestClass();
        ListMethod();
    }

    public static void TestClass() {
        System.out.println("Get class info --- ");
        System.out.println("Object class : " + Object.class);
        System.out.println("String class : " + String.class);
        System.out.println("String[] class : " + String[].class);
        System.out.println("Calendar class : " + Calendar.class);
        System.out.println("TestClass class : " + MyRTTI.class);
        System.out.println("class for int : " + int.class);

        System.out.println();
        System.out.println("xgy".getClass());
        System.out.println(Calendar.getInstance().getClass());

    }

    public static void ListMethod() {
        String str = "java.lang.String";
        @SuppressWarnings("rawtypes")
        Class c = null;
        try {
            c = Class.forName(str);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        @SuppressWarnings("rawtypes")
        Constructor[] cons = c.getConstructors();
        printList("Constructors", cons);

        Method[] meths = c.getMethods();
        printList("Methods", meths);
    }

    static void printList(String s, Object[] o) {
        System.out.println("***" + s + "***");
        for (int i = 0; i < o.length; ++i) {
            System.out.println(o[i].toString());
        }
    }

}
