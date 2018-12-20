package com.tsgkim.chapter1.stopThread.stop.section2;

import org.junit.Test;

/**
 *
 * @author: shiguang.tu
 * @create: 2018/8/9 下午11:50
 */
public class Start {

    @Test
    public void myTest(){

        MyThread myThread = new MyThread();

        myThread.start();

    }

}
