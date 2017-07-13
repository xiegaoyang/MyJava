package com.xgy.base;

/**
 * Created by gowild.cn on 2017/6/10.
 */
public class datastruct {

    private static final int size = 10;
    private static int a[] = new int[]{2, 3, 1, 5, 9, 8, 4, 7, 6, 0};

    public static void print() {
        for (int i = 0; i < size; ++i) {
            System.out.print(a[i] + " ");
        }
    }

    public static void main(String[] args) {
        bubble(a, size);
        print();
    }

    public static void bubble(int[] a, int size) {

        for (int i = 0; i < size; ++i) {
            for (int j = size - 1; j > i; j--) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }

    }

}
