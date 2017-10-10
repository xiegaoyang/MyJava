package com.xgy.utils;


import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;

/**
 * Created by hadoop on 2017/5/28.
 */
public class StringUtil {

    /**
     * stringת��Ϊint�������ַ���
     *
     * @param str
     * @return
     */
    public static int stringToInt(String str) {

//        return  Integer.parseInt(str);
//        return  Integer.valueOf(str);
        return Integer.valueOf(str).intValue();
    }

    /**
     * stringת��Ϊbyte���飬�������ñ����ʽ
     *
     * @param str
     * @return
     */
    public static byte[] stringToByte(String str) {
//        return str.getBytes();
//        return str.getBytes("UTF-8"); //ASCII��
        return str.getBytes();
    }

    /**
     * �ж��ַ����Ƿ�������
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

    /**
     * �ж��ַ����Ƿ�Ϊ��
     *
     * @param str
     * @return
     */
    public static boolean isNullOrEmpty(String str) {
        return null == str || str.length() == 0;
    }

    /**
     * �ַ�У��
     *
     * @param c
     * @return
     */
    public static boolean isValidIdChar(char c) {
        return "abcdefghijklmnopqrstuvwxyzABCDEFGHIGKLMNOPQRSTUVWXYZ0123456789$_#@".indexOf(c) != -1;
    }

    /**
     * �ַ�����ת
     *
     * @param originStr
     * @return
     */
    public static String reverse(String originStr) {
        if (originStr == null || originStr.length() <= 1)
            return originStr;
        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }

    public static void main(String[] args) {


        String repeatStr = StringUtils.repeat("123", 3);
        System.out.println(repeatStr);

        int n = StringUtils.countMatches("11112222", "1");
        System.out.println(n);


    }

    public static class MyString2 {

        public static void main(String[] args) {
            // TODO Auto-generated method stub

            testUnicode();

            String str = "1024";
            // int num = Integer.parseInt(str);
            int num = Integer.valueOf(str, 16);// ??str?��????????16????????????????int
            System.out.println(num);

            String s1 = "???";
            try {
                String s2 = new String(s1.getBytes("GB2312"), "ISO-8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            System.out.println(str.substring(1));

            System.out.println(reverse(str));
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
}
