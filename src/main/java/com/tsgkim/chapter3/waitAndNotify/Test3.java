package com.tsgkim.chapter3.waitAndNotify;

import org.junit.Test;

/**
 *
 * @author: shiguang.tu
 * @create: 2018/11/27 9:00 PM
 */
public class Test3 {

    @Test
    public void myTest() throws InterruptedException {

        Test3 test3 = new Test3();

        Thread thread = new Thread(() -> {

            synchronized (test3) {

                try {
                    test3.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }


        });

        thread.start();

        Thread.sleep(2000);

        /**
         * 当线程是 wait 状态又执行 interrupt()，将会报 java.lang.InterruptedException
         */
        thread.interrupt();

    }

}
