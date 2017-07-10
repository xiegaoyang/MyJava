package com.xgy.base.string;


import org.apache.commons.lang3.StringUtils;

/**
 * Created by hadoop on 2017/5/28.
 */
public class StringUtil {

    /**
     * 判断字符串是否都是数字
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {

        if (null != str && !"".equals(str.trim())) {
            return str.matches("^[0-9]*$");
        }

        return false;

    }


    public static void main(String[] args) {
        String str = "100";
        int value = Integer.valueOf(str);
        System.out.println(value);

        String str2 = Integer.toString(value);
        System.out.println(str2);


        String repeatStr = StringUtils.repeat(str2, 3);
        System.out.println(repeatStr);

        int n = StringUtils.countMatches("11112222", "1");
        System.out.println(n);
    }





}
