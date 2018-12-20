package com.tsgkim.chapter3.join;

/**
 *
 * @author: shiguang.tu
 * @create: 2018/11/29 10:18 AM
 */
public class Test3 {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {

            for (int i = 0; i < Integer.MAX_VALUE; i++) {

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                new String();
                Math.random();

                System.out.println("thread1正在执行......");
            }

        });

        thread.start();

        /**
         * {@link Thread#join(long)} 和 {@link Thread#sleep(long)} 两者都是阻塞线程
         * {@link Thread#join(long)} 内部有 {@link Thread#wait(long)}，所以有释放锁的特点，而 {@link Thread#sleep(long)} 不释放锁
         */
        thread.join(2000);

        System.out.println("2s后线程 thread 释放锁，我执行");

    }

}
