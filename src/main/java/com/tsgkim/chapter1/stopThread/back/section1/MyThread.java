package com.tsgkim.chapter1.stopThread.back.section1;

import org.junit.Test;

/**
 *
 * @author: shiguang.tu
 * @create: 2018/8/4 下午8:26
 */
public class MyThread extends Thread {

    @Override
    public void run() {

        for (int i = 0; i < 5000; i++) {

            // 下面两个作用一样
            //if (isInterrupted()) {
            if (interrupted()) {

                System.out.println("我是 for 里面的代码，我的线程停止了，但是如果我这个 for 下面还有代码，还可以继续运行");

                return;

            }

            System.out.println(String.format("i = %s", i));

        }

        // 如果 for 下面还有代码，还会继续执行，如果不然其执行，可以手动在 for 里面 return 解决
        System.out.println("我是 for 下面继续运行的代码，线程并未停止");

    }

    @Test
    public void myTest(){

        MyThread myThread = new MyThread();

        myThread.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        myThread.interrupt();

    }

}
