package com.xgy.utils;

import java.util.Random;

/**
 * Created by hadoop on 2017/8/31.
 */
public class NumberUtil {

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
        NumberUtil.getRandomInt(0, 100);
    }


}
