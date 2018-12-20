package com.tsgkim.chapter1.currentThread.section1;

import org.junit.Test;

/**
 *
 * @author: shiguang.tu
 * @create: 2018/7/30 下午10:55
 */
public class MyThread extends Thread {

    public MyThread() {
        System.out.println(String.format("Constructor method print thread name = %s", currentThread().getName()));
    }

    @Override
    public void run() {
        System.out.println(String.format("Run method print thread name = %s", currentThread().getName()));
    }

    @Test
    public void testRun(){

        MyThread myThread = new MyThread();

        // .run() 也是被 main 线程调用
        myThread.run();

    }

    @Test
    public void testStart(){

        MyThread myThread = new MyThread();

        // .start() 另外起一个 Thread-0 线程调用
        myThread.start();

    }

    @Test
    public void testStart2(){

        MyThread myThread = new MyThread();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // .start() 另外起一个 Thread-0 线程调用
        myThread.start();

        System.out.println(Thread.currentThread().getName());
        System.out.println(myThread.currentThread().getName());

    }
}
