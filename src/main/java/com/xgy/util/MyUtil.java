package com.xgy.util;

import java.util.Random;

/**
 * Created by Administrator on 2016/12/7.
 */
public class MyUtil {

    public static int getRandomInt(int min, int max) {
        //max += 1;  // 返回[0,10)集合中的整数，注意不包括10
        Random random = new Random();
        int s = random.nextInt(max)%(max-min+1) + min;
        return s;
    }


    public static void main(String[] args) {
        for (int i=0; i<200; ++i)
        System.out.print(MyUtil.getRandomInt(0, 10) + " ");
    }

}
