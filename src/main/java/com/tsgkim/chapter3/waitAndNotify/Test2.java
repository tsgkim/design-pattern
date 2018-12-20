package com.tsgkim.chapter3.waitAndNotify;

/**
 *
 * @author: shiguang.tu
 * @create: 2018/11/27 7:37 PM
 */
public class Test2 {

    public static void main(String[] args) {

        Object lock = new Object();

        Thread thread1 = new Thread(() -> {

            synchronized (lock) {

                System.out.println(String.format("%s, 开始", Thread.currentThread().getName()));

                try {
                    /**
                     * wait() 执行后，锁马上释放
                     */
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(String.format("%s, 结束", Thread.currentThread().getName()));

            }

        });

        thread1.setName("A");

        Thread thread2 = new Thread(() -> {

            synchronized (lock) {

                System.out.println(String.format("%s, 开始", Thread.currentThread().getName()));

                /**
                 * notify() 执行后，wait() 状态线程不能马上就能执行，需要等到程序退出 synchronized 代码块之后才能执行
                 */
                lock.notify();

                System.out.println(String.format("%s, 结束", Thread.currentThread().getName()));

            }

        });

        thread2.setName("B");

        thread1.start();
        thread2.start();

    }

}
