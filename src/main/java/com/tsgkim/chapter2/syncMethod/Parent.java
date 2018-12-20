package com.tsgkim.chapter2.syncMethod;

import org.junit.Test;

/**
 *
 * @author: shiguang.tu
 * @create: 2018/11/22 2:24 PM
 */
public class Parent {

    public void say() {
        System.out.println(String.format("Parent thread name=%s, time=%s",
                Thread.currentThread().getName(), System.currentTimeMillis()));
    }

    public synchronized void say2() {
        System.out.println(String.format("Parent thread name=%s, time=%s",
                Thread.currentThread().getName(), System.currentTimeMillis()));
    }

    /**
     * 同步不可继承
     */
    @Test
    public void myTest() {

        Child child = new Child();

        Thread thread1 = new Thread(() -> child.say());
        thread1.setName("A");

        Thread thread2 = new Thread(() -> child.say());
        thread2.setName("B");

        Thread thread3 = new Thread(() -> child.say());
        thread3.setName("C");

        Thread thread4 = new Thread(() -> child.say());
        thread4.setName("D");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }

    /**
     * 父类如果想同步执行，也得加锁
     */
    @Test
    public void myTest2() {

        Child child = new Child();

        Thread thread1 = new Thread(() -> child.say2());
        thread1.setName("A");

        Thread thread2 = new Thread(() -> child.say2());
        thread2.setName("B");

        Thread thread3 = new Thread(() -> child.say2());
        thread3.setName("C");

        Thread thread4 = new Thread(() -> child.say2());
        thread4.setName("D");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }

}

class Child extends Parent {

    @Override
    public synchronized void say() {

        System.out.println(String.format("Child thread name=%s, time=%s",
                Thread.currentThread().getName(), System.currentTimeMillis()));

        super.say();

    }

    @Override
    public synchronized void say2() {

        System.out.println(String.format("Child thread name=%s, time=%s",
                Thread.currentThread().getName(), System.currentTimeMillis()));

        super.say2();
    }
}
