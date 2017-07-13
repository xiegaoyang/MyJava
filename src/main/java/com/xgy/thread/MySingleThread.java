package com.xgy.thread;

/**
 * Created by root on 16-10-20.
 */
public class MySingleThread extends Thread {

    public static void main(String[] args) {
        MySingleThread mySingleThread = new MySingleThread();
        mySingleThread.setName("WorkThread");
        mySingleThread.start();
        System.out.println("main ThreadName : " + Thread.currentThread().getName());
        System.out.println("main ThreadId : " + Thread.currentThread().getId());
    }

    @Override
    public void run() {
        System.out.println("ThreadName : " + Thread.currentThread().getName());
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ThreadId : " + Thread.currentThread().getId());
    }

}
