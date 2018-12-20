package com.tsgkim.chapter1.isAlive.section2;

import org.junit.Test;

/**
 * Study:
 *      Thread.currentThread() 和 this 导致的 isAlive 差异
 * @author: shiguang.tu
 * @create: 2018/7/30 下午11:23
 */
public class Start {

    @Test
    public void myTest(){

        MyThread myThread = new MyThread();

        Thread a = new Thread(myThread, "A");
        a.start();

    }
}
