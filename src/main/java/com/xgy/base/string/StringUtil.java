package com.xgy.base.string;

/**
 * Created by hadoop on 2017/5/28.
 */
public class StringUtil {


    public static boolean isNumeric(String str) {

        if (null != str && !"".equals(str.trim())) {
            return str.matches("^[0-9]*$");
        } else {
            return false;
        }
    }



}
