package com.xgy.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by hadoop on 2017/8/31.
 */
public class TimeUtil {

    /**
     * 获取当前时间
     *
     * @param format， 如"yyyy-MM-dd HH:mm:ss"
     * @return
     */
    public static String getCurrentTime(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Calendar cal = Calendar.getInstance();// 取当前日期。
        return sdf.format(cal.getTime());
    }


    /**
     * 获取当前日期
     *
     * @return
     */
    public static String getCurrentDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(new Date());
    }

}
