package com.xgy.datastructure;

import java.util.Arrays;

/**
 * Created by hadoop on 2017/7/29.
 */
public class SampleSelectSort {

    public static void sort(int[] a, int n) {
        for (int i = 0; i < n; ++i) {
            int min = i;
            for (int j = i + 1; j < n; ++j) { //找出最小值
                if (a[min] > a[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = a[min];
                a[min] = a[i];
                a[i] = temp;
            }
        }
    }


    public static void main(String[] args) {
        int a[] = SortUtil.a;
        sort(a, a.length);
        System.out.println(Arrays.toString(a));
    }

}
