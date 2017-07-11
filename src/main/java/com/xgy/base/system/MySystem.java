package com.xgy.base.system;

/**
 * Created by gowild.cn on 2017/7/11.
 */
public class MySystem {

    public static void getSystemInfo() {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    public static void main(String[] args) {
        MySystem.getSystemInfo();
    }

}
