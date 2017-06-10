package com.xgy.classLoader;

/**
 * Created by hadoop on 2017/4/7.
 */
public class MyClassLoader {

    public static void main(String[] args) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println(loader);
        System.out.println(loader.getParent());
        System.out.println(loader.getParent().getParent());
    }

}
