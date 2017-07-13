package com.xgy.base.container;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by hadoop on 2017/3/31.
 */
public class MyArrayList {

    public static void main(String[] args) {
        ArrayListPerformanceTest();
    }

    public static void ListToArray() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        Integer[] values = new Integer[list.size()];
        list.toArray(values);
        System.out.println(values[0]);
    }


    public static void ArrayListPerformanceTest() {

        List<String> list = new ArrayList<String>();
        long t1, t2;
        for (int j = 0; j < 10000000; j++)
//        for(int j = 0; j < 100000; j++)
        {
            list.add("aaaaaa" + j);
        }

//        System.out.println("List first visit method:");
//        t1=System.currentTimeMillis();
//        for(String tmp:list)
//        {
//            //System.out.println(tmp);
//        }
//        t2=System.currentTimeMillis();
//        System.out.println("Run Time:" + (t2 -t1) + "(ms)");


//        System.out.println("List second visit method:");
//        t1=System.currentTimeMillis();
//        for(int i = 0; i < list.size(); i++)
//        {
//            list.get(i);
//            //System.out.println(list.get(i));
//        }
//        t2=System.currentTimeMillis();
//        System.out.println("Run Time:" + (t2 -t1) + "(ms)");


        System.out.println("List Third visit method:");
        Iterator<String> iter = list.iterator();
        t1 = System.currentTimeMillis();
        while (iter.hasNext()) {
            iter.next();
            //System.out.println(iter.next());
        }
        t2 = System.currentTimeMillis();
        System.out.println("Run Time:" + (t2 - t1) + "(ms)");

        System.out.println("Finished!!!!!!!!");
    }

}
