package com.xgy.thread;

/**
 * Created by hadoop on 2017/7/19.
 */
// 1.现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行
public class MyJoin {
//    T3先执行，在T3的run中，调用t2.join，让t2执行完成后再执行t3
//    在T2的run中，调用t1.join，让t1执行完成后再让T2执行

    public static void main(String[] args) {

        final Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1");
            }
        });

        final Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //引用t1线程，等待t1线程执行完
                    t1.join();
                    System.out.println("t2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        final Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //引用t2线程，等待t2线程执行完
                    t2.join();
                    System.out.println("t3");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t3.start();
        t2.start();
        t1.start();

    }


}
