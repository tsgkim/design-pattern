package com.tsgkim.chapter3.waitAndNotify;

/**
 *
 * @author: shiguang.tu
 * @create: 2018/11/27 10:33 PM
 */
public class Test4 {

    public static void main(String[] args) {

        Object object = new Object();

        new Thread(() -> {

            System.out.println("进入线程");

            synchronized (object) {

                try {
                    /**
                     * 超时自动唤醒线程
                     */
                    object.wait(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            System.out.println("线程结束");

        }).start();

    }

}
