package com.tsgkim.chapter2.myVolatile;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author: shiguang.tu
 * @create: 2018/11/27 11:44 AM
 */
public class Test4 extends Thread {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {

            atomicInteger.incrementAndGet();

            //try {
            //    Thread.sleep(10);
            //} catch (InterruptedException e) {
            //    e.printStackTrace();
            //}

        }

        System.out.println(String.format("%s, count=%s", Thread.currentThread().getName(), atomicInteger.get()));

    }

    public static void main(String[] args) {

        Test4 test4 = new Test4();

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 100; i++) {

            Thread thread = new Thread(test4);
            thread.setName(String.valueOf(i));

            threads.add(thread);

        }

        for (int i = 0; i < 100; i++) {

            threads.get(i).start();

        }

    }
}
