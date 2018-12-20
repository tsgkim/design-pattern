package com.tsgkim.threadPool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author: shiguang.tu
 * @create: 2018/12/2 3:10 PM
 */
public class MyThreadFactory implements ThreadFactory {

    private final String namePrefix;

    private final AtomicInteger nextId = new AtomicInteger(1);

    public MyThreadFactory(String group) {
        this.namePrefix = "tsgkim thread factory" + group + "-worker-";
    }

    @Override
    public Thread newThread(Runnable r) {

        Thread thread = new Thread(null, r, (namePrefix + nextId.getAndIncrement()), 0);

        System.out.println(String.format("%s 已经由线程工厂生产出来了", thread.getName()));

        return thread;
    }

    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor1 = new ThreadPoolExecutor(
                1,
                2,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(2),
                new MyThreadFactory("第一机房"),
                new MyThreadRejectHandler());

        ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(
                1,
                2,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(2),
                new MyThreadFactory("第二机房"),
                new MyThreadRejectHandler());

        MyThread myThread = new MyThread();
        for (int i = 0; i < 6; i++) {
            threadPoolExecutor1.execute(myThread);
            //threadPoolExecutor2.execute(myThread);
        }


    }
}

class MyThreadRejectHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println(String.format("task reject, %s", executor.toString()));
    }
}

class MyThread implements Runnable {

    private final AtomicLong count = new AtomicLong(0L);

    @Override
    public void run() {
        System.out.println(String.format("running-%s", count.getAndIncrement()));
    }
}
