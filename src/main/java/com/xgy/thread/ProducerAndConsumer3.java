//http://blog.csdn.net/monkey_d_meng/article/details/6251879/  很好的demo

package com.xgy.thread;

/**
 * Created by hadoop on 2017/8/12.
 */

import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 仓库类Storage实现缓冲区
 * <p>
 * Email:530025983@qq.com
 *
 * @author MONKEY.D.MENG 2011-03-15
 */

class Storage2 {

    // 仓库最大存储量  
    private final int MAX_SIZE = 100;

    // 仓库存储的载体  
    private LinkedList<Object> list = new LinkedList<Object>();

    // 生产num个产品  
    public void produce(int num) {

        // 同步代码段  
        synchronized (list) {
            // 如果仓库剩余容量不足  
            while (list.size() + num > MAX_SIZE) {
                System.out.println("【要生产的产品数量】:" + num + "\t【库存量】:" + list.size() + "\t暂时不能执行生产任务!");
                try {
                    // 由于条件不满足，生产阻塞  
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // 生产条件满足情况下，生产num个产品  
            for (int i = 1; i <= num; ++i) {
                list.add(new Object());
            }

            System.out.println("【已经生产产品数】:" + num + "\t【现仓储量为】:" + list.size());

            list.notifyAll();
        }
    }

    // 消费num个产品  
    public void consume(int num) {

        // 同步代码段  
        synchronized (list) {
            // 如果仓库存储量不足  
            while (list.size() < num) {
                System.out.println("【要消费的产品数量】:" + num + "\t【库存量】:"
                        + list.size() + "\t暂时不能执行生产任务!");
                try {
                    // 由于条件不满足，消费阻塞  
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // 消费条件满足情况下，消费num个产品  
            for (int i = 1; i <= num; ++i) {
                list.remove();
            }

            System.out.println("【已经消费产品数】:" + num + "\t【现仓储量为】:" + list.size());

            list.notifyAll();
        }
    }

    // get/set方法  
    public LinkedList<Object> getList() {
        return list;
    }

    public void setList(LinkedList<Object> list) {
        this.list = list;
    }

    public int getMAX_SIZE() {
        return MAX_SIZE;
    }
}


/**
 * 仓库类Storage实现缓冲区
 * <p>
 * Email:530025983@qq.com
 *
 * @author MONKEY.D.MENG 2011-03-15
 */
class Storage {

    // 仓库最大存储量  
    private final int MAX_SIZE = 100;
    // 锁  
    private final Lock lock = new ReentrantLock();
    // 仓库满的条件变量  
    private final Condition full = lock.newCondition();
    // 仓库空的条件变量  
    private final Condition empty = lock.newCondition();
    // 仓库存储的载体  
    private LinkedList<Object> list = new LinkedList<Object>();

    // 生产num个产品  
    public void produce(int num) {
        // 获得锁  
        lock.lock();

        // 如果仓库剩余容量不足  
        while (list.size() + num > MAX_SIZE) {
            System.out.println("【要生产的产品数量】:" + num + "\t【库存量】:" + list.size()
                    + "\t暂时不能执行生产任务!");
            try {
                // 由于条件不满足，生产阻塞  
                full.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 生产条件满足情况下，生产num个产品  
        for (int i = 1; i <= num; ++i) {
            list.add(new Object());
        }

        System.out.println("【已经生产产品数】:" + num + "\t【现仓储量为】:" + list.size());

        // 唤醒其他所有线程  
        full.signalAll();
        empty.signalAll();

        // 释放锁  
        lock.unlock();
    }

    // 消费num个产品  
    public void consume(int num) {
        // 获得锁  
        lock.lock();

        // 如果仓库存储量不足  
        while (list.size() < num) {
            System.out.println("【要消费的产品数量】:" + num + "\t【库存量】:" + list.size()
                    + "\t暂时不能执行生产任务!");
            try {
                // 由于条件不满足，消费阻塞  
                empty.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 消费条件满足情况下，消费num个产品  
        for (int i = 1; i <= num; ++i) {
            list.remove();
        }

        System.out.println("【已经消费产品数】:" + num + "\t【现仓储量为】:" + list.size());

        // 唤醒其他所有线程  
        full.signalAll();
        empty.signalAll();

        // 释放锁  
        lock.unlock();
    }

    // set/get方法  
    public int getMAX_SIZE() {
        return MAX_SIZE;
    }

    public LinkedList<Object> getList() {
        return list;
    }

    public void setList(LinkedList<Object> list) {
        this.list = list;
    }
}

/**
 * 生产者类Producer3继承线程类Thread
 * <p>
 * Email:530025983@qq.com
 *
 * @author MONKEY.D.MENG 2011-03-15
 */
class Producer3 extends Thread {
    // 每次生产的产品数量  
    private int num;

    // 所在放置的仓库  
    private Storage storage;

    // 构造函数，设置仓库  
    public Producer3(Storage storage) {
        this.storage = storage;
    }

    // 线程run函数  
    public void run() {
        produce(num);
    }

    // 调用仓库Storage的生产函数  
    public void produce(int num) {
        storage.produce(num);
    }

    // get/set方法  
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}

/**
 * 消费者类Consumer3继承线程类Thread
 * <p>
 * Email:530025983@qq.com
 *
 * @author MONKEY.D.MENG 2011-03-15
 */
class Consumer3 extends Thread {

    // 每次消费的产品数量  
    private int num;

    // 所在放置的仓库  
    private Storage storage;

    // 构造函数，设置仓库  
    public Consumer3(Storage storage) {
        this.storage = storage;
    }

    // 线程run函数  
    public void run() {
        consume(num);
    }

    // 调用仓库Storage的生产函数  
    public void consume(int num) {
        storage.consume(num);
    }

    // get/set方法  
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}


/**
 * 仓库类Storage实现缓冲区
 * <p>
 * Email:530025983@qq.com
 *
 * @author MONKEY.D.MENG 2011-03-15
 */
class Storage3 {

    // 仓库最大存储量
    private final int MAX_SIZE = 100;

    // 仓库存储的载体
    private LinkedBlockingQueue<Object> list = new LinkedBlockingQueue<Object>(100);

    // 生产num个产品
    public void produce(int num) {
        // 如果仓库剩余容量为0
        if (list.size() == MAX_SIZE) {
            System.out.println("【库存量】:" + MAX_SIZE + "/t暂时不能执行生产任务!");
        }

        // 生产条件满足情况下，生产num个产品
        for (int i = 1; i <= num; ++i) {
            try {
                // 放入产品，自动阻塞
                list.put(new Object());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("【现仓储量为】:" + list.size());
        }
    }

    // 消费num个产品
    public void consume(int num) {
        // 如果仓库存储量不足
        if (list.size() == 0) {
            System.out.println("【库存量】:0/t暂时不能执行生产任务!");
        }

        // 消费条件满足情况下，消费num个产品
        for (int i = 1; i <= num; ++i) {
            try {
                // 消费产品，自动阻塞
                list.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("【现仓储量为】:" + list.size());
    }

    // set/get方法
    public LinkedBlockingQueue<Object> getList() {
        return list;
    }

    public void setList(LinkedBlockingQueue<Object> list) {
        this.list = list;
    }

    public int getMAX_SIZE() {
        return MAX_SIZE;
    }
}

/**
 * 测试类Test
 * <p>
 * Email:530025983@qq.com
 *
 * @author MONKEY.D.MENG 2011-03-15
 */
public class ProducerAndConsumer3 {

    public static void main(String[] args) {
        // 仓库对象  
        Storage storage = new Storage();

        // 生产者对象  
        Producer3 p1 = new Producer3(storage);
        Producer3 p2 = new Producer3(storage);
        Producer3 p3 = new Producer3(storage);
        Producer3 p4 = new Producer3(storage);
        Producer3 p5 = new Producer3(storage);
        Producer3 p6 = new Producer3(storage);
        Producer3 p7 = new Producer3(storage);

        // 消费者对象  
        Consumer3 c1 = new Consumer3(storage);
        Consumer3 c2 = new Consumer3(storage);
        Consumer3 c3 = new Consumer3(storage);

        // 设置生产者产品生产数量  
        p1.setNum(10);
        p2.setNum(10);
        p3.setNum(10);
        p4.setNum(10);
        p5.setNum(10);
        p6.setNum(10);
        p7.setNum(80);

        // 设置消费者产品消费数量  
        c1.setNum(50);
        c2.setNum(20);
        c3.setNum(30);

        // 线程开始执行  
        c1.start();
        c2.start();
        c3.start();
        p1.start();
        p2.start();
        p3.start();
        p4.start();
        p5.start();
        p6.start();
        p7.start();
    }
}  