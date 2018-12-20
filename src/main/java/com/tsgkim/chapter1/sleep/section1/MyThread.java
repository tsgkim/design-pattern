package com.tsgkim.chapter1.sleep.section1;

import me.andpay.ti.test.mockito.MockitoExtension;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author: shiguang.tu
 * @create: 2018/8/4 下午8:12
 */
@ExtendWith(MockitoExtension.class)
public class MyThread extends Thread {

    @Override
    public void run() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testStart() {

        MyThread myThread = new MyThread();

        long startTime = System.currentTimeMillis();

        myThread.start();

        long endTime = System.currentTimeMillis();

        assertEquals(startTime, endTime);
    }

    @Test
    public void testRun() {

        MyThread myThread = new MyThread();

        long startTime = System.currentTimeMillis();

        myThread.run();

        long endTime = System.currentTimeMillis();

        assertTrue((endTime - startTime > 0));

    }

}
