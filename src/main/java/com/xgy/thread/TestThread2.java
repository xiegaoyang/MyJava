package com.xgy.thread;

/**
 * Created by hadoop on 2017/3/16.
 */

/*
 * 匿名内部类的格式：
 */
public class TestThread2 {
    public static void main(String[] args) {
        // 继承thread类实现多线程
        new Thread() {
            public void run() {
                for (int x = 0; x < 100; x++) {
                    System.out.println(Thread.currentThread().getName() + "--"
                            + x);
                }
            }
        }.start();
        ;

        // 实现runnable借口，创建多线程并启动
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int x = 0; x < 100; x++) {
                    System.out.println(Thread.currentThread().getName() + "--"
                            + x);
                }
            }
        }) {
        }.start();

        // 更有难度的,在Thread匿名内部类的里面再一次重写run方法
        //在实际运行时的结果是 hello+x。以thread的run方法为准。但是此处无意义
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                for (int x = 0; x < 100; x++) {
                    System.out.println("java" + "--" + x);
                }

            }
        }) {
            public void run() {
                for (int x = 0; x < 100; x++) {
                    System.out.println("hello" + "--" + x);
                }
            }
        }.start();
    }
}

