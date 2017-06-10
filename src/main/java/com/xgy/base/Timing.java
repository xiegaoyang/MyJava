package com.xgy.base;

import junit.framework.Test;

/**
 * Created by Administrator on 2016/11/18.
 */
public class Timing {

    private static long startTime = 0;
    private static long endTime = 0;

    public static void StartTime() {
        startTime = System.currentTimeMillis();
    }

    public static String EndTime() {
        endTime = System.currentTimeMillis();
        return Integer.toString((int)(endTime - startTime)) + "ms";
    }

    public static void main(String[] args) {
//        Timing.Test();

        Timing.StartTime();
        for(int i=0;i<1000000;i++){
            Math.random();
        }
        System.out.println(Timing.EndTime());

    }


    public static void Test() {
        long startMili = System.currentTimeMillis();// 当前时间对应的毫秒数
        System.out.println("开始 : "+startMili);
        // 执行一段代码,求一百万次随机值
        for(int i=0;i<1000000;i++){
            Math.random();
        }
        long endMili = System.currentTimeMillis();
        System.out.println("结束 : "+endMili);
        System.out.println("耗时 : "+(endMili-startMili)+"毫秒");
    }
}
