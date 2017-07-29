package com.xgy.datastructure;

import java.util.Arrays;

/**
 * Created by hadoop on 2017/7/29.
 */
public class ShellSort {

    public static void sort(int[] a, int n) {
        int k;
        for (int gap = n / 4; gap > 0; gap = gap / 4) { //分组  总共有n/3组，每组元素的下标是等差数列，
            for (int i = 0; i < gap; ++i) { //对每组进行直接插入排序
                for (int j = i + gap; j < n; j += gap) { //第i组
                    if (a[j] < a[j - gap]) {
                        int temp = a[j];
                        for (k = j - gap; k >= i && a[k] > temp; k = k - gap) {
                            a[k + gap] = a[k];
                        }
                        a[k + gap] = temp;
                    }
                }
            }
        }
    }

    public static void sort2(int[] a, int n) {
        int k;
        for (int gap = n / 2; gap > 0; gap = gap / 2) { //分组  总共有n/3组，每组元素的下标是等差数列，
            for (int j = gap; j < n; j += gap) { //对每组进行直接插入排序
                if (a[j] < a[j - gap]) {  //与组内元素比较,特定两组
                    int temp = a[j];
                    for (k = j - gap; k >= 0 && a[k] > temp; k = k - gap) {
                        a[k + gap] = a[k];
                    }
                    a[k + gap] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int a[] = SortUtil.a;
        sort(a, a.length);
//        sort2(a, a.length);
        System.out.println(Arrays.toString(a));
    }

}
