package com.xgy.datastructure;

import java.util.Arrays;

public class BubbleSort {

    /**
     * 正宗的冒泡排序：每一趟比较找出最小值   从下到上
     *
     * @param a
     * @param n
     */
    public static void BubbleSort1(int[] a, int n) {

        int i = 0;
        int j = 0;
        int temp = 0;

        for (i = 0; i < n; ++i) {
            for (j = n - 1; j > i; --j) {
                if (a[j] < a[j - 1]) {
                    temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
    }

    public static void BubbleSort2(int[] a, int n) {

        int i = 0;
        int j = 0;
        int temp = 0;

        for (i = 0; i < n; ++i) {
            for (j = i + 1; j < n; ++j) {
                if (a[i] > a[j]) {
                    temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }
    }

    public static void BubbleSort3(int[] a, int n) {

        int i = 0;
        int j = 0;
        int temp = 0;

        boolean flag = true;

        for (i = 0; i < n && flag; ++i) {
            flag = false;

            for (j = n - 1; j > i; --j) {
                if (a[j] < a[j - 1]) {
                    temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                    if (!flag) {
                        flag = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        int a[] = SortUtil.a;

//        BubbleSort.BubbleSort1(a, a.length);
//        BubbleSort.BubbleSort2(a, a.length);
        BubbleSort.BubbleSort3(a, a.length);


        System.out.println(Arrays.toString(a));


    }

}
