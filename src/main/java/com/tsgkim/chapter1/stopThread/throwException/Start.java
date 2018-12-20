package com.tsgkim.chapter1.stopThread.throwException;

import org.junit.Test;

/**
 *
 * @author: shiguang.tu
 * @create: 2018/8/4 下午8:58
 */
public class Start {

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
