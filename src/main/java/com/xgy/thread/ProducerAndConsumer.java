package com.xgy.thread;

import com.xgy.base.system.SystemUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 2017/8/12.
 */

class Producer extends Thread {

    private Queue queue;

    Producer(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            int node = SystemUtil.getRandomInt(0, 100);
            queue.add(node);
            System.out.println(SystemUtil.getCurrentDate() + "  Producer-" + Thread.currentThread().getId() + ": " + node);
        }
    }
}

class Consumer extends Thread {

    private Queue queue;

    Consumer(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            System.out.println(SystemUtil.getCurrentDate() + "  Consumer-" + Thread.currentThread().getId() + ": " + queue.get());
        }
    }
}

class Queue {

    private int queueSize;
    private List<Integer> queue = new ArrayList<>();

    Queue(int queueSize) {
        this.queueSize = queueSize;
    }

    public void add(int node) {

        synchronized (this) {

            try {
                if (queueSize == queue.size()) {
                    System.out.println("Queue is full");
                    wait();
                }

                queue.add(node);

                if (!queue.isEmpty()) {
                    notify();
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int get() {

        synchronized (this) {
            int node = -1;
            try {
                if (queue.isEmpty()) {
                    wait();
                }

                node = queue.get(0);
                queue.remove(0);

                if (queueSize != queue.size()) {
                    notify();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return node;
        }
    }
}

public class ProducerAndConsumer {

    public static void main(String[] args) {

        Queue queue = new Queue(100);

        Producer producer1 = new Producer(queue);
        Producer producer2 = new Producer(queue);
        Producer producer3 = new Producer(queue);
        Producer producer4 = new Producer(queue);
        Producer producer5 = new Producer(queue);
        Consumer consumer1 = new Consumer(queue);
        Consumer consumer2 = new Consumer(queue);

        producer1.start();
        producer2.start();
        producer3.start();
        producer4.start();
        producer5.start();
        consumer1.start();
        consumer2.start();

        try {
            producer1.join();
            producer2.join();
            producer3.join();
            producer4.join();
            producer5.join();
            consumer1.join();
            consumer2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
