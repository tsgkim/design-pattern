package com.tsgkim.signal;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author: shiguang.tu
 * @create: 2018/12/1 5:37 PM
 */
public class MyCountDownLatch {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(3);

        Runnable runnable = () -> {

            if (Math.random() > 0.5) {
                throw new RuntimeException("异常");
            }

            System.out.println(String.format("%s, 当前线程执行完毕", Thread.currentThread().getName()));

            countDownLatch.countDown();

        };

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(runnable);
            thread.setName(String.valueOf(i));
            thread.start();

            thread.setUncaughtExceptionHandler((t, e) -> System.out.println(String.format("%s出现异常了, %s",
                    t.getName(), e.getMessage())));
        }

        countDownLatch.await(10, TimeUnit.SECONDS);

        System.out.println("所有线程执行完毕");

    }

}
