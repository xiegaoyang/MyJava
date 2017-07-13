package com.xgy.pool;

import com.xgy.util.MyUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static java.lang.System.exit;
import static java.lang.Thread.sleep;

/**
 * Created by Administrator on 2016/12/7.
 */


public class MyPool {

    private static MyPool myPool = null;
    List<MyObject> objectList = new ArrayList<MyObject>();
    private int maxSize = 1000;
    private int initSize = 300;
    private int curCapacity = 0;
    private int step = 100;
    private int count = 0;
    private String[] names = new String[]{"xiegy", "liut", "yut"};
    private int[] ages = new int[]{26, 27, 28};
    private List<MyObject> usedList = new ArrayList<MyObject>();
    private List<MyObject> freeList = new ArrayList<MyObject>();

    private MyPool() {
        for (int i = 0; i < initSize; ++i) {
            MyObject myObject = new MyObject();
            myObject.setName(names[MyUtil.getRandomInt(0, names.length)]);
            myObject.setAge(ages[MyUtil.getRandomInt(0, ages.length)]);
            freeList.add(myObject);
        }
        curCapacity += initSize;
    }

    public static MyPool getInstance() {
        if (null == myPool) {
            synchronized (MyPool.class) {
                if (null == myPool) {
                    myPool = new MyPool();
                }
            }
        }
        return myPool;
    }

    public static void main(String[] args) {

        testMultiThread();


    }

    public static void testMultiThread() {

        System.out.println(Thread.currentThread().getName());

        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));

        for (int i = 0; i < 5; ++i) {
            Task task = new Task();
            executor.execute(task);
        }

        try {
            if (null != executor) {
                executor.shutdown();
            }
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void testSingleThread() {


        MyPool myPool = MyPool.getInstance();
        myPool.statistic();

        MyObject myObject = null;
        int index = 0;
        for (int i = 0; i < 100000; ++i) {
            index = MyUtil.getRandomInt(0, 10000);

            if (index % 2 == 0) {
                System.out.println(i + ", get, index = " + index);
                myObject = myPool.get();
                if (null != myObject) {
                    //System.out.println(myObject.getName() + ", " + myObject.getAge());
                }
                myPool.getObjectList().add(myObject);
            } else {
                if (myPool.getObjectList().size() == 0) {
                    continue;
                }
                System.out.println(i + ", put, index = " + index);
                myObject = myPool.getObjectList().get(0);
                myPool.getObjectList().remove(myObject);
                myPool.put(myObject);

            }

            myPool.statistic();

            try {
                sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public List<MyObject> getObjectList() {
        return objectList;
    }

    public MyObject get() {
        MyObject myObject = null;
        synchronized (MyPool.class) {

            if (freeList.size() > 0) {
                myObject = freeList.get(0);

                usedList.add(myObject);
                freeList.remove(myObject);
            } else {

                if (0 == count) {
                    System.out.println("init has used");
                } else {
                    System.out.println("第" + count + "补充");
                }

                if (curCapacity >= maxSize) {
                    System.out.println("has use");
                    exit(-1);
                    return myObject;
                }

                for (int i = 0; i < step; ++i) {
                    MyObject myObject1 = new MyObject();
                    myObject1.setName(names[MyUtil.getRandomInt(0, names.length)]);
                    myObject1.setAge(ages[MyUtil.getRandomInt(0, ages.length)]);
                    freeList.add(myObject1);
                }

                curCapacity += step;
                ++count;

                myObject = freeList.get(0);
                freeList.remove(myObject);
                usedList.add(myObject);
            }
        }
        return myObject;
    }

    public void put(MyObject myObject) {
        synchronized (MyPool.class) {
            if (!usedList.contains(myObject)) {
                System.out.println("error");
                exit(-1);
            }
            usedList.remove(myObject);
            freeList.add(myObject);
        }
    }

    public void statistic() {
        synchronized (MyPool.class) {
            System.out.println("used size = " + usedList.size() + ", free size = " + freeList.size());
        }
    }

}
