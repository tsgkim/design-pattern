package com.tsgkim.chapter1.isAlive.section1;

import org.junit.Test;

/**
 *
 * @author: shiguang.tu
 * @create: 2018/7/30 下午11:10
 */
public class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println(String.format("IsAlive = %s", isAlive()));
    }

    @Test
    public void myTest(){

        MyThread myThread = new MyThread();

        System.out.println(String.format("Begin ---- myThread.isAlive() = %s", myThread.isAlive()));

        myThread.start();

        // 这个地方打印的值不确定线程是否存活，打印为 true 是因为 myThread 线程还未执行完毕，如果休眠 1s，打印为 false
        //try {
        //    Thread.sleep(1000);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}
        System.out.println(String.format("End ---- myThread.isAlive() = %s", myThread.isAlive()));

    }

}
