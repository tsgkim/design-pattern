package com.tsgkim.chapter1.stopThread.stop.section1;

/**
 *
 * @author: shiguang.tu
 * @create: 2018/8/9 下午11:47
 */
public class MyThread extends Thread {

    @Override
    public void run() {

        int i = 0;

        while (true) {

            System.out.println(i ++);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
