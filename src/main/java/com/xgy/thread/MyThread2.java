package com.xgy.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;


public class MyThread2 extends Thread {

    private int count = 0;

    public static void main(String[] args) {
        try {

            for (int i = 0; i < 20; ++i) {
                System.out.println(Thread.currentThread().getName() + " " + i);

                if (10 == i) {
                    MyThread2 thread1 = new MyThread2();
                    if (!thread1.isDaemon()) {
                        System.out.println("�����ػ��߳�");
                        thread1.setDaemon(true);//
                    }
                    thread1.setName("xgy");
                    thread1.start();
                    new MyThread2().start();
                }

                if (5 == i) {
                    SecondThread thread3 = new SecondThread();
                    new Thread(thread3, "lt").start();
                }

                if (1 == i) {
                    ThirdThread thread4 = new ThirdThread();
                    FutureTask<Integer> task = new FutureTask<Integer>(thread4);
                    new Thread(task, "yt").start();
                }

            }
            Thread.sleep(10);

            Thread.currentThread().join();

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {

        }

    }

    public void run() {
        // while(true)
        for (int i = 0; i < 10; ++i) {
            ++count;
            System.out.println(getName() + " count = " + count);
        }
    }
}

class SecondThread implements Runnable {

    public void run() {
        for (int i = 0; i < 10; ++i) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

}

class ThirdThread implements Callable<Integer> {
    public Integer call() {
        int i = 0;
        for (i = 0; i < 10; ++i) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }

        return i;
    }
}
