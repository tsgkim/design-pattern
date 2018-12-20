package com.tsgkim.lock.reetrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: shiguang.tu
 * @create: 2018/11/27 5:28 PM
 */
public class Test3 {

    public static void main(String[] args) throws InterruptedException {

        ReentrantLock reentrantLock = new ReentrantLock();

        Condition conditionA = reentrantLock.newCondition();
        Condition conditionB = reentrantLock.newCondition();

        new Thread(() -> {

            reentrantLock.lock();

            System.out.println("start A");

            try {
                conditionA.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("end A");

            reentrantLock.unlock();

        }).start();

        new Thread(() -> {

            reentrantLock.lock();

            System.out.println("start B");

            try {
                conditionB.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("end B");

            reentrantLock.unlock();

        }).start();

        Thread.sleep(2000);

        new Thread(() -> {

            reentrantLock.lock();

            conditionA.signal();

            reentrantLock.unlock();

        }).start();

    }

}