package com.tsgkim.chapter1.isAlive.section2;

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
        System.out.println(String.format("Thread.currentThread().isAlive() = %s", Thread.currentThread().isAlive()));
        System.out.println(String.format("this.isAlive() = %s", this.isAlive()));
        System.out.println("MyThread end");

    }

    @Override
    public void run() {

        System.out.println("Run begin");
        System.out.println(String.format("Thread.currentThread().getName() = %s", Thread.currentThread().getName()));
        System.out.println(String.format("this.getName() = %s", this.getName()));
        System.out.println(String.format("Thread.currentThread().isAlive() = %s", Thread.currentThread().isAlive()));
        System.out.println(String.format("this.isAlive() = %s", this.isAlive()));
        System.out.println("Run end");

    }

}


