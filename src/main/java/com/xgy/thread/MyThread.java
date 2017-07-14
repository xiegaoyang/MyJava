package com.xgy.thread;

/**
 * Created by hadoop on 2017/4/5.
 */
public class MyThread extends Thread {

    private int threadNo;

    public MyThread(int threadNo) {
        this.threadNo = threadNo;
    }

    public static void main(String[] args) throws Exception {
        for (int i = 1; i < 10; i++) {
            new MyThread(i).start();
            Thread.sleep(1);
        }
    }

    @Override
    public synchronized void run() {
        for (int i = 1; i < 2; i++) {
            System.out.println("No." + threadNo + ":" + i);
        }
    }
}
