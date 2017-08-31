package com.xgy.base.system;

import java.net.URL;

/**
 * Created by gowild.cn on 2017/7/11.
 */
public class MySystem {

    public static void getSystemInfo() {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    public static void getResource() {
        URL classPath = Thread.currentThread().getContextClassLoader().getResource("");
        System.out.println(classPath.toString());
    }

    public static void main(String[] args) {
        MySystem.getSystemInfo();
        MySystem.getResource();
    }

}
