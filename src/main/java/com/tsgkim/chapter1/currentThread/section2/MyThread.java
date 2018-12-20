package com.tsgkim.chapter1.currentThread.section2;

/**
 *
 * @author: shiguang.tu
 * @create: 2018/7/30 下午10:57
 */
public class MyThread extends Thread{

    public MyThread() {

        System.out.println("MyThread begin");
        System.out.println(String.format("Thread.currentThread().getName() = %s", Thread.currentThread().getName()));
        System.out.println(String.format("this.getName() = %s", this.getName()));
        System.out.println("MyThread end");

    }

    @Override
    public void run() {

        System.out.println("Run begin");
        System.out.println(String.format("Thread.currentThread().getName() = %s", Thread.currentThread().getName()));
        System.out.println(String.format("this.getName() = %s", this.getName()));
        System.out.println("Run end");

    }
}
