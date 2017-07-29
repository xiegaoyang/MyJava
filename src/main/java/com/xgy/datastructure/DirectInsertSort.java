package com.xgy.datastructure;

import java.util.Arrays;

/**
 * Created by hadoop on 2017/7/29.
 */
public class DirectInsertSort {

    public static void sort(int[] a, int n) {
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j <= i - 1; ++j) {
                if (a[i] < a[j]) {
                    int temp = a[i];
                    for (int k = i; k > j; k--) {
                        a[k] = a[k - 1];
                    }
                    a[j] = temp;
                    break;
                }
            }
        }
    }

    public static void sort2(int[] a, int n) {
        int i, j;
        for (i = 1; i < n; ++i) {
            if (a[i] < a[i - 1]) {
                int temp = a[i];
                for (j = i - 1; j >= 0 && a[j] > temp; j--) {
                    a[j + 1] = a[j];
                }
                a[j + 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int a[] = SortUtil.a;
        sort2(a, a.length);
        System.out.println(Arrays.toString(a));
    }

}
