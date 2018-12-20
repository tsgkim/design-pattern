package com.tsgkim.chapter1.stopThread.isInterrupted.section1;

import com.tsgkim.chapter1.stopThread.MyThread;
import org.junit.Test;

/**
 *
 * @author: shiguang.tu
 * @create: 2018/8/4 下午8:58
 */
public class Start {

    /**
     * isInterrupted()
     *      测试线程是否已经中断，但不清除状态标志
     */
    @Test
    public void myTest(){

        MyThread myThread = new MyThread();

        myThread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        myThread.interrupt();

        System.out.println(String.format("isInterrupted = %s", myThread.isInterrupted()));
        System.out.println(String.format("isInterrupted = %s", myThread.isInterrupted()));

    }

}
