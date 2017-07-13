package com.xgy.thread;

public class TestMyThread {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Thread t1 = new Thread(new DemoThread());
        int priority = t1.getPriority();
        System.out.println("priority = " + priority);
        System.out.println("name = " + t1.getName());

        t1.setName("xgy");

        t1.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("program exit.");

        System.gc();
        Runtime.getRuntime().exit(0);
    }

}

class DemoThread implements Runnable {

    public void run() {
        while (!Thread.interrupted()) {
            int i = 0;
            for (i = 0; i < 10; ++i) {
                System.out.println("i = " + i);
            }

            if (10 == i) {
                break;
            }

        }
    }
}
