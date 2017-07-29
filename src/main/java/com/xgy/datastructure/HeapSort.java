package com.xgy.datastructure;

import java.util.Arrays;

/**
 * Created by hadoop on 2017/7/29.
 */
public class HeapSort {


    /**
     * 递归操作，比较父节点和左右孩子节点，找到最大节点
     *
     * @param a，待调整的堆数组
     * @param i，待调整的数组元素的位置
     * @param n，数组的长度
     */

    public static void heapAdjust(int[] a, int i, int n) {

        int left = 2 * i;
        int right = 2 * i + 1;
        int max = i;

        if (left < n) {

            if (left < n && a[left] > a[max]) {
                max = left;
            }
            if (right < n && a[right] > a[max]) {
                max = right;
            }

            if (max != i) {
                int temp = a[max];
                a[max] = a[i];
                a[i] = temp;

                heapAdjust(a, max, n);
            }
        }

    }

    public static void sort(int[] a, int n) {

        //构建堆，初始化堆
        for (int i = n / 2; i >= 0; i--) { //从下到上调整堆，叶子结点
            heapAdjust(a, i, n);
        }

        //堆排序
        for (int j = n - 1; j > 0; j--) { //从上到下进行调整

            //交换a[0]和a[j]
            int temp = a[0];
            a[0] = a[j];
            a[j] = temp;

            //不断缩小调整heap的范围，每一次调整完毕保证第一个元素是当前序列的最大值
            heapAdjust(a, 0, j);

        }
    }

    public static void main(String[] args) {
        int a[] = SortUtil.a;
        sort(a, a.length);
        System.out.println(Arrays.toString(a));
    }

}
