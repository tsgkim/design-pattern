package com.tsgkim.lock.reetrantLock;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: shiguang.tu
 * @create: 2018/11/29 12:33 PM
 */
public class Test1 {

    private int i = 0;

    private ReentrantLock reentrantLock = new ReentrantLock();

    public void add() {

        reentrantLock.lock();

        i++;

        System.out.println(String.format("i=%s", i));

        reentrantLock.unlock();

    }

    synchronized public void add2() {

        i++;

        System.out.println(String.format("i=%s", i));

    }

    @Test
    public void myTest() {

        Test1 test1 = new Test1();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> test1.add()).start();
        }

    }

    @Test
    public void myTest2() {

        Test1 test1 = new Test1();

        for (int i = 0; i < 10; i++) {
            new Thread(() -> test1.add2()).start();
        }

    }


}
