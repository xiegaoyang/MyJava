package com.xgy.datastructure;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int i = 0;
        int j = 0;
        int temp = 0;

        boolean flag = true;

        int a[] = {3, 4, 1, 2, 5, 6, 7, 9, 8, 0};

        for (i = 0; i < a.length && flag; ++i) {
            flag = false;

            for (j = a.length - 1; j > i; --j) {
                if (a[j] > a[j - 1]) {
                    temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                    if (!flag) {
                        flag = true;
                    }
                }
            }
        }

        System.out.println(Arrays.toString(a));

//		for (int k : a)
//		{
//			System.out.println(k);
//		}

    }

}
