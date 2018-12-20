package com.tsgkim.lock.reetrantLock;

import org.junit.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: shiguang.tu
 * @create: 2018/11/27 5:28 PM
 */
public class Test2 {

    private ReentrantLock reentrantLock = new ReentrantLock();

    private Condition condition = reentrantLock.newCondition();

    @Test
    public void myTest() throws InterruptedException {

        // 没有对代码块加锁，await() 无效
        condition.await();

    }

    @Test
    public void myTest2() {

        // 没有对代码块加锁，signal() 无效
        condition.signal();

    }

    public static void main(String[] args) throws InterruptedException {

        ReentrantLock reentrantLock = new ReentrantLock();

        Condition condition = reentrantLock.newCondition();

        new Thread(() -> {

            reentrantLock.lock();

            System.out.println("start");

            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("end");

            reentrantLock.unlock();

        }).start();

        Thread.sleep(2000);

        new Thread(() -> {

            reentrantLock.lock();

            condition.signal();

            reentrantLock.unlock();

        }).start();

    }

}