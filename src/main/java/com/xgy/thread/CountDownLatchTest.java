package com.xgy.thread;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by hadoop on 2017/4/5.
 */
public class CountDownLatchTest {

    private static CountDownLatch count = new CountDownLatch(4);
    private static ExecutorService service = Executors.newFixedThreadPool(6);

    public static void main(String args[]) throws InterruptedException {

        for (int i = 0; i < 4; i++) {
            service.execute(() -> {
                // 模拟任务耗时
                try {
                    int timer = new Random().nextInt(5);
                    TimeUnit.SECONDS.sleep(timer);
                    System.out.printf("%s时完成磁盘的统计任务,耗费%d秒.\n", new Date().toString(), timer);
                    // 任务完成之后,计数器减一
                    count.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        // 主线程一直被阻塞,知道count的计数器被设置为0
        count.await();

        System.out.printf("%s时全部任务都完成,执行合并计算.\n", new Date().toString());
        service.shutdown();
    }
}
