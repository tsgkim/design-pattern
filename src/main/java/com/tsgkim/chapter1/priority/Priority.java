package com.tsgkim.chapter1.priority;

import java.util.Random;

/**
 *
 * @author: shiguang.tu
 * @create: 2018/11/21 9:14 PM
 */
public class Priority {

    private static void myRun() {

        int count = 0;

        for (int i = 0; i < 10; i++) {

            for (int j = 0; i < 50000; i++) {

                Random random = new Random();
                random.nextInt();

                count += j;

            }
        }

        System.out.println(String.format("thread=%s", Thread.currentThread().getName()));

    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {

            Thread thread1 = new Thread(Priority::myRun);
            thread1.setPriority(10);
            thread1.setName("AA");

            Thread thread2 = new Thread(Priority::myRun);
            thread2.setPriority(1);
            thread2.setName("B");

            thread1.start();
            thread2.start();
        }
    }


}
