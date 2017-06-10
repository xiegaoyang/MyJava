package com.xgy.datastructure;

/**
 * Created by hadoop on 2017/4/12.
 */
public class MyBinaryQuery {

    public static int binaryQuery(int[] a, int target) {

        int low = 0;
        int middle = 0;
        int high = a.length - 1;

        while (low <= high) {
            middle = (low + high)/2;
            if (a[middle] > target) {
                high = middle - 1;
            } else if (a[middle] < target) {
                low = middle + 1;
            } else {
                return middle;
            }
        }

        return -1;

    }

    public static int binaryQuery2(int[] a, int low, int high, int target) {
        int middle = (low + high)/2;
        if (a[middle] > target) {
            return binaryQuery2(a, low, middle - 1, target);
        } else if (a[middle] < target) {
            return binaryQuery2(a, middle + 1, high, target);
        } else {
            return middle;
        }
    }

    public static void main(String[] args) {
        int a[] = new int[]{1,3,5,6,7,8,9,10,13,16,19};
//        System.out.println(MyBinaryQuery.binaryQuery(a, 8));
        System.out.println(MyBinaryQuery.binaryQuery2(a, 0, a.length - 1, 8));
    }

}
