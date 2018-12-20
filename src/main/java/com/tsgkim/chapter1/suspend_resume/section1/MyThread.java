package com.tsgkim.chapter1.suspend_resume.section1;

import org.junit.Test;

/**
 *
 * @author: shiguang.tu
 * @create: 2018/8/10 上午12:46
 */
public class MyThread extends Thread {

    private int i = 0;

    @Override
    public void run() {

        while (true) {

            i ++ ;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    @Test
    public void myTest() throws InterruptedException {

        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(5000);

        // A 段
        myThread.suspend();
        System.out.println(String.format("A = %s, i = %s", System.currentTimeMillis(), myThread.getI()));
        Thread.sleep(5000);
        System.out.println(String.format("A = %s, i = %s", System.currentTimeMillis(), myThread.getI()));

        // B 段
        myThread.resume();
        Thread.sleep(5000);

        // C 段
        myThread.suspend();
        System.out.println(String.format("C = %s, i = %s", System.currentTimeMillis(), myThread.getI()));
        Thread.sleep(5000);
        System.out.println(String.format("C = %s, i = %s", System.currentTimeMillis(), myThread.getI()));


    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
