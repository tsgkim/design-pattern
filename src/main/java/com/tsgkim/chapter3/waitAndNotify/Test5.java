package com.tsgkim.chapter3.waitAndNotify;

import me.andpay.ti.util.StringUtil;

/**
 * 一对一生产消费模式
 *
 * @author: shiguang.tu
 * @create: 2018/11/27 11:20 PM
 */
public class Test5 {

    private static String value;

    public static void main(String[] args) {

        Object lock = new Object();

        Thread produceThread = new Thread(() -> {

            while (true) {

                synchronized (lock) {

                    if (StringUtil.isNotBlank(value)) {

                        try {

                            System.out.println("等待消费");

                            lock.wait();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    } else {

                        value = "aa";

                        System.out.println("生产完毕");

                        lock.notify();

                    }

                }

            }

        });

        Thread consumerThread = new Thread(() -> {

            while (true) {

                synchronized (lock) {

                    if (StringUtil.isNotBlank(value)) {

                        value = null;

                        System.out.println("消费完毕");

                        lock.notify();

                    } else {

                        try {

                            System.out.println("等待生产");

                            lock.wait();

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }

                }

            }

        });

        produceThread.start();
        consumerThread.start();

    }


}
