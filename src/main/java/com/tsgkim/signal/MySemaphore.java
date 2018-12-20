package com.tsgkim.signal;

import java.util.concurrent.Semaphore;

/**
 * 3个窗口过安检，其中一个空闲，队列中第一个人到该空闲窗口接收检查
 *
 * @author: shiguang.tu
 * @create: 2018/12/1 5:57 PM
 */
public class MySemaphore {

    public static void main(String[] args) {

        /**
         * 设置3个信号量，表示3个售票窗口
         *
         * 如果 new Semaphore(1); 就是互斥锁
         *
         */
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 5; i++) {

            int finalI = i;

            new Thread(() -> {

                try {
                    semaphore.acquire();

                    System.out.println(String.format("%s 乘客正在查验中", finalI));

                    if (finalI % 2 == 0) {
                        Thread.sleep(15000);
                        System.out.println(String.format("%s 乘客身份可疑", finalI));
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();

                } finally {

                    // 释放持有的信号量
                    semaphore.release();

                    System.out.println(String.format("%s 乘客已完成服务", finalI));
                }

            }).start();

        }

    }

}
