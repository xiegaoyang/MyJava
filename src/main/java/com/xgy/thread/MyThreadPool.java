package com.xgy.thread;

/**
 * Created by root on 16-10-20.
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class MyThreadPool {

    public static void test() {

        ExecutorService singleThreadExecutor = Executors.newCachedThreadPool();

        for (int i = 0; i < 100; i++) {
            final int index = i;
            singleThreadExecutor.execute(new Runnable() {
                public void run() {
                    try {
                        while(true) {
                            System.out.println(index);
                            Thread.sleep(10 * 1000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {

        MyThreadPool.test();

//        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
//
//        for (int i = 0; i < 10; i++) {
//            final int index = i;
//            try {
//                Thread.sleep(index * 1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            cachedThreadPool.execute(new Runnable() {
//                public void run() {
//                    System.out.println(index);
//                }
//            });
//        }



//                System.out.println(Runtime.getRuntime().availableProcessors());
//
//                ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
//                for (int i = 0; i < 10; i++) {
//                    final int index = i;
//
//                    fixedThreadPool.execute(new Runnable() {
//                        public void run() {
//                            try {
//                                System.out.println(index);
//                                Thread.sleep(2000);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    });
//                }



//        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
//        scheduledThreadPool.schedule(new Runnable() {
//            public void run() {
//                System.out.println("delay 3 seconds");
//            }
//        }, 3, TimeUnit.SECONDS);  //表示延迟3秒执行




}
}
