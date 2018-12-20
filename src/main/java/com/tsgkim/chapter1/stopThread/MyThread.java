package com.tsgkim.chapter1.stopThread;

/**
 *
 * @author: shiguang.tu
 * @create: 2018/8/4 下午8:26
 */
public class MyThread extends Thread {

    @Override
    public void run() {

        for (int i = 0; i < 5000; i++) {
            System.out.println(String.format("i = %s", i));
        }

    }
}
