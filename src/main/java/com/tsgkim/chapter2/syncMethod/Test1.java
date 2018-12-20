package com.tsgkim.chapter2.syncMethod;

import org.junit.Test;

/**
 * 同步 synchronized 方法无限等待
 * 解决方法：
 *      不同的方法设置不同的锁
 *
 * @author: shiguang.tu
 * @create: 2018/11/22 9:58 PM
 */
public class Test1 {

    synchronized public void say() {

        System.out.println(String.format("Say name=%s", Thread.currentThread().getName()));

        while (true){}

    }

    synchronized public void speak() {

        System.out.println(String.format("Speak name=%s", Thread.currentThread().getName()));

    }

    Object object1 = new Object();

    public void say2() {

        synchronized (object1) {

            System.out.println(String.format("Say name=%s", Thread.currentThread().getName()));

            while (true){}

        }

    }

    Object object2 = new Object();

    public void speak2() {

        synchronized (object2) {
            System.out.println(String.format("Speak name=%s", Thread.currentThread().getName()));
        }

    }

    @Test
    public void myTest() {

        Test1 test1 = new Test1();

        new Thread(() -> test1.say()).start();
        new Thread(() -> test1.speak()).start();

    }

    @Test
    public void myTest2() {

        Test1 test1 = new Test1();

        new Thread(() -> test1.say2()).start();
        new Thread(() -> test1.speak2()).start();

    }

}
