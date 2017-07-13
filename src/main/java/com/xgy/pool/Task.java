package com.xgy.pool;

import com.xgy.util.MyUtil;

import java.util.List;

import static java.lang.Thread.sleep;

/**
 * Created by Administrator on 2016/12/7.
 */
class Task implements Runnable {

    public void run() {

        String threadName = Thread.currentThread().getName();
        System.out.println(threadName);

        MyPool myPool = MyPool.getInstance();
        List<MyObject> objectList = myPool.getObjectList();

        MyObject myObject = null;
        int index = 0;
        for (int i = 0; i < 100000; ++i) {
            index = MyUtil.getRandomInt(0, 10000);

            if (index % 2 == 0) {
                System.out.println(threadName + i + ", get, index = " + index);
                myObject = myPool.get();
                if (null != myObject) {
                    //System.out.println(myObject.getName() + ", " + myObject.getAge());
                }
                myPool.getObjectList().add(myObject);
            } else {
                if (myPool.getObjectList().size() == 0) {
                    continue;
                }
                System.out.println(threadName + i + ", put, index = " + index);
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
}