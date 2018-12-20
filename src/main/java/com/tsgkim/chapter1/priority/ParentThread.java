package com.tsgkim.chapter1.priority;

import org.junit.Test;

/**
 *
 * @author: shiguang.tu
 * @create: 2018/11/21 8:24 PM
 */
public class ParentThread extends Thread {

    @Override
    public void run() {

        System.out.println(String.format("Parent thread priority=%s", Thread.currentThread().getPriority()));

        new ChildThread().start();

    }

    @Test
    public void myTest() {

        new ParentThread().start();

    }

    @Test
    public void myTest2() {

        Thread.currentThread().setPriority(6);

        new ParentThread().start();

    }

}

class ChildThread extends ParentThread {

    @Override
    public void run() {
        System.out.println(String.format("Child thread priority=%s", Thread.currentThread().getPriority()));
    }
}
