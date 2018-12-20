package com.tsgkim.chapter1.test;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {

    private static final int TEST_THREAD_COUNT = 3;

    @Test
    public void testThreadSync3() {
        final Vector<Integer> list = new Vector<Integer>();
        Thread[] threads = new Thread[TEST_THREAD_COUNT];
        final CountDownLatch latch = new CountDownLatch(TEST_THREAD_COUNT);

        for (int i = 0; i < TEST_THREAD_COUNT; i++) {
            final int num = i;
            threads[i] = new Thread(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep((int) (Math.random() * 1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    list.add(num);
                    System.out.println(list.toString());
                    latch.countDown();
                }
            });
            threads[i].start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
