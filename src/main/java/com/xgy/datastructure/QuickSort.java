package com.xgy.datastructure;

import java.util.Arrays;

/**
 * Created by hadoop on 2017/7/29.
 */
public class QuickSort {

    public static void sort(int[] a, int low, int high) {

        if (low > high) {
            return;
        }

        int i = low;
        int j = high;
        int k = a[low];

        while (i < j) {

            while (j > i && a[j] > k) {  //找到
                j--;
            }
            a[i] = a[j];

            while (i < j && a[i] < k) {
                i++;
            }
            a[j] = a[i];

        }

        a[i] = k;

        sort(a, low, i - 1);
        sort(a, i + 1, high);

    }

    public static void main(String[] args) {
        int a[] = SortUtil.a;

        sort(a, 0, a.length - 1);

        System.out.println(Arrays.toString(a));

    }
}
