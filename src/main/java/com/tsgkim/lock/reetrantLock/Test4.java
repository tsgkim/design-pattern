package com.tsgkim.lock.reetrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author: shiguang.tu
 * @create: 2018/11/30 5:59 PM
 */
public class Test4 {

    private boolean isCrossA = false;

    private ReentrantLock reentrantLock = new ReentrantLock();

    private Condition condition = reentrantLock.newCondition();

    public void crossA() {

        reentrantLock.lock();

        while (isCrossA == false) {
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("CrossA");

        isCrossA = false;

        condition.signalAll();

        reentrantLock.unlock();

    }

    public void crossB() {

        reentrantLock.lock();

        while (isCrossA) {
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("CrossB");

        isCrossA = true;

        condition.signalAll();

        reentrantLock.unlock();

    }

    public static void main(String[] args) {

        Test4 test4 = new Test4();

        for (int i = 0; i < 10; i++) {

            new Thread(() -> test4.crossA()).start();

            new Thread(() -> test4.crossB()).start();

        }

    }

}
