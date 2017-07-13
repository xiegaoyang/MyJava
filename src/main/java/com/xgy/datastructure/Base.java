package com.xgy.datastructure;

import java.util.Arrays;

/**
 * Created by hadoop on 2017/4/13.
 */
public class Base {

    /*
     *  打印阵列
     *
     */
    public static void print() {
        for (int i = 0; i <= 5; ++i) {
            for (int j = 5; j >= 0; --j) {
                if (i < j) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
            }
            System.out.println("");
        }
    }

    /*
     *  设有ｎ个人依围成一圈，从第１个人开始报数，数到第ｍ个人出
     *  列，然后从出列的下一个人开始报数，数到第ｍ个人又出列，…，如此反复到所
     *  有的人全部出列为止。设ｎ个人的编号分别为1，2，…，n，打印出出列的顺序；
     *  要求用java 实现。
     */

    public static void queue(int n, int num) {

        Boolean[] array = new Boolean[n];
        Arrays.fill(array, true);

        int index = 0;
        int length = array.length;

        while (n-- > 0) {

            for (int i = 0; i < num; ++i) {

                while (false == array[(index++) % length]) {
                }

                if (i == num - 1) {
                    array[(index - 1) % length] = false;
                    for (boolean item : array) {
                        System.out.print(item + " ");
                    }
                    System.out.println("");
                }

            }
        }

    }


    public static void main(String[] args) {
//        Base.print();
        Base.queue(10, 4);
    }

}
