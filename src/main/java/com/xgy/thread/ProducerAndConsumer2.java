package com.xgy.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hadoop on 2017/8/12.
 */

class ProducerManager {

    private int threadSize;
    private Queue queue;
    private List<Producer> threadPool = new ArrayList<>();

    ProducerManager(int threadSize, Queue queue) {
        this.threadSize = threadSize;
        this.queue = queue;
    }

    public void init() {
        for (int i = 0; i < threadSize; ++i) {
            Producer producer = new Producer(queue);
            threadPool.add(producer);
        }
    }

    public boolean start() {
        for (Producer worker : threadPool) {
            worker.start();
        }
        return true;
    }

    public void uninit() {

    }
}

class ConsumerManager {

    private int threadSize;
    private Queue queue;
    private List<Consumer> threadPool = new ArrayList<>();

    ConsumerManager(int threadSize, Queue queue) {
        this.threadSize = threadSize;
        this.queue = queue;
    }

    public void init() {
        for (int i = 0; i < threadSize; ++i) {
            Consumer consumer = new Consumer(queue);
            threadPool.add(consumer);
        }
    }

    public boolean start() {
        for (Consumer worker : threadPool) {
            worker.start();
        }
        return true;
    }

    public void uninit() {

    }
}


public class ProducerAndConsumer2 {
    public static void main(String[] args) {

        Queue queue = new Queue(100);
        ProducerManager producerManager = new ProducerManager(5, queue);
        ConsumerManager consumerManager = new ConsumerManager(2, queue);

        producerManager.init();
        producerManager.start();

        consumerManager.init();
        consumerManager.start();


    }
}
