package com.tsgkim.lock.reetrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author: shiguang.tu
 * @create: 2018/11/30 9:25 PM
 */
public class Test5 {

    public static void main(String[] args) {

        // 公平锁
        ReentrantLock reentrantLock = new ReentrantLock(false);

        Runnable runnable = () -> {

            reentrantLock.lock();

            System.out.println(String.format("%s", Thread.currentThread().getName()));

            reentrantLock.unlock();

        };

        for (int i = 0; i < 10; i++) {

            Thread thread = new Thread(runnable);
            thread.setName(String.valueOf(i));

            thread.start();

        }

    }

}
