package com.xgy.base.string;


import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;

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


    public static class MyString {


        public static void test() {

            String a = "Programming";
            String b = new String("Programming");
            String c = "Program" + "ming";

            System.out.println(a == b);
            System.out.println(a == c);
            System.out.println(a.equals(b));
            System.out.println(a.equals(c));
            System.out.println(a.intern() == b.intern());

        }

        public static void main(String[] args) {

            test();


        }


    }

    public static class MyString2 {

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
}
