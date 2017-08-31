package com.xgy.utils;

/**
 * Created by hadoop on 2017/7/17.
 */
public class SystemUtil {


    public static void systemProperties() {
        System.out.println(System.getProperty("file.encoding"));
    }


    public static void main(String[] args) {
        SystemUtil.systemProperties();
    }


}
