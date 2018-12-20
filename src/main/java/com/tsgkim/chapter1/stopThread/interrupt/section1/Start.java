package com.tsgkim.chapter1.stopThread.interrupt.section1;

import com.tsgkim.chapter1.stopThread.MyThread;
import org.junit.Test;

/**
 *
 * @author: shiguang.tu
 * @create: 2018/8/4 下午8:29
 */
public class Start {

    /**
     * interrupt() 方法仅仅是在当前线程中打了一个停止的标记，并不是真正停止线程
     */
    @Test
    public void myTest() {

        MyThread myThread = new MyThread();

        myThread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        myThread.interrupt();


    }

}
