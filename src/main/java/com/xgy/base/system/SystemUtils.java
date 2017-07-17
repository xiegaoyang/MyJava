package com.xgy.base.system;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hadoop on 2017/7/17.
 */
public class SystemUtils {

    public static String getCurrentTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(new Date());
    }


    public static void main(String[] args) {
        System.out.println(SystemUtils.getCurrentTime());
    }
}
