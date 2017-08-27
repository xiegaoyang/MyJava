package com.xgy.base.system;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * Created by hadoop on 2017/7/17.
 */
public class SystemUtil {

    public static String getCurrentDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();// 取当前日期。
        return format.format(cal.getTime());
    }


    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getCurrentTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(new Date());
    }

    /**
     * 获取随机整数
     *
     * @param min
     * @param max
     * @return
     */
    public static int getRandomInt(int min, int max) {
        //max += 1;  // 返回[0,10)集合中的整数，注意不包括10
        Random random = new Random();
        return random.nextInt(max) % (max - min + 1) + min;
    }




    public static void main(String[] args) {

        System.out.println(SystemUtil.getCurrentTime());

        for (int i = 0; i < 200; ++i) {
            System.out.print(SystemUtil.getRandomInt(0, 10) + " ");
        }

        System.out.println(SystemUtil.getCurrentDate());
    }
}
