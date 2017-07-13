package com.xgy.base.string;

import java.io.UnsupportedEncodingException;

public class MyString2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        testUnicode();

        String str = "1024";
        // int num = Integer.parseInt(str);
        int num = Integer.valueOf(str, 16);// ��str�е����ֵ���16���Ƶ�����Ȼ��ת��Ϊint
        System.out.println(num);

        String s1 = "���";
        try {
            String s2 = new String(s1.getBytes("GB2312"), "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(str.substring(1));

        System.out.println(reverse(str));
    }

    public static String reverse(String originStr) {
        if (originStr == null || originStr.length() <= 1)
            return originStr;
        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }

    public static void testUnicode() {
        String str = "hello";

        byte[] srtbyte = null;

        try {
            srtbyte = str.getBytes("UTF-8");
            String res = new String(srtbyte, "UTF-8");
            System.out.println(res);
        } catch (UnsupportedEncodingException e) {

            // TODO Auto-generated catch block
            e.printStackTrace();

        }
    }

}
