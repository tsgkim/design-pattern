package com.tsgkim.chapter2.myVolatile;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author: shiguang.tu
 * @create: 2018/11/27 11:44 AM
 */
public class Test3 extends Thread {

    /**
     * volatile 只保证可见性，不保证原子性
     */
    volatile private static int count = 0;

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            ++count;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(String.format("%s, count=%s", Thread.currentThread().getName(), count));

    }

    public static void main(String[] args) {

        Test3 test3 = new Test3();

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 100; i++) {

            Thread thread = new Thread(test3);
            thread.setName(String.valueOf(i));

            threads.add(thread);

        }

        for (int i = 0; i < 100; i++) {

            threads.get(i).start();

        }

    }
}
