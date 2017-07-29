package com.xgy.datastructure;

import java.util.Arrays;

/**
 * Created by hadoop on 2017/7/29.
 */
public class MergeSort {

    public static void merge(int[] a, int low, int mid, int high) {

        int i = low; // i是第一段序列的下标
        int j = mid + 1; // j是第二段序列的下标
        int k = 0; // k是临时存放合并序列的下标

        int[] a2 = new int[high - low + 1]; // a2是临时合并序列

        // 扫描第一段和第二段序列，直到有一个扫描结束
        while (i <= mid && j <= high) {
            // 判断第一段和第二段取出的数哪个更小，将其存入合并序列，并继续向下扫描
            if (a[i] <= a[j]) {
                a2[k++] = a[i++];
            } else {
                a2[k++] = a[j++];
            }
        }

        // 若第一段序列还没扫描完，将其全部复制到合并序列
        while (i <= mid) {
            a2[k++] = a[i++];
        }

        // 若第二段序列还没扫描完，将其全部复制到合并序列
        while (j <= high) {
            a2[k++] = a[j++];
        }

        // 将合并序列复制到原始序列中
        for (k = 0, i = low; i <= high; i++, k++) {
            a[i] = a2[k];
        }

    }

    public static void sort(int[] a, int n) {
        for (int gap = 1; gap < n; gap = gap * 2) {
            int i;
            for (i = 0; i + 2 * gap - 1 < n; i = i + 2 * gap) {
                merge(a, i, i + gap - 1, i + 2 * gap - 1);
            }
            if (i + gap - 1 < n) { //奇数情况
                merge(a, i, i + gap - 1, n - 1);
            }
        }
    }

    public static void sort2(int[] a, int start, int end) {
        if (end - start > 0) {
            int mid = (start + end) / 2;
            sort2(a, start, mid);
            sort2(a, mid + 1, end);
            merge(a, start, mid, end);
        }
    }

    public static void main(String[] args) {
        int a[] = SortUtil.a;
//        sort(a, a.length);
        sort2(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }


    /**
     * 合并两个有序数组
     *
     * @param a
     * @param n
     * @param b
     * @param m
     * @param c
     */
    void mergeArray(int a[], int n, int b[], int m, int c[]) {

        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {
            if (a[i] < b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }
        }

        while (i < n) {
            c[k++] = a[i++];
        }

        while (j < m) {
            c[k++] = b[j++];
        }
    }

}
