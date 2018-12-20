package com.tsgkim.chapter3.waitAndNotify;

import java.util.ArrayList;
import java.util.List;

/**
 * 一生产多消费模式
 *
 * @author: shiguang.tu
 * @create: 2018/11/27 11:20 PM
 */
public class Test6 {

    private static Object lock = new Object();

    private static List<Double> list = new ArrayList<>();

    private static void pop() {

        while (true) {

            synchronized (lock) {

                if (list.size() == 0) {
                    try {

                        lock.wait();

                        System.out.println(String.format("%s, 等待生产", Thread.currentThread().getName()));

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                /**
                 *  如果第三处代码唤醒了其它的 pop(）线程而不是 push() 线程，将导致 java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
                 */
                System.out.println(String.format("%s pop value=%s", Thread.currentThread().getName(), list.get(0)));

                list.remove(0);

                //**** 第三处代码 ****
                lock.notify();
                //**** 第三处代码 ****

            }

        }

    }

    private static void push() {

        while (true) {

            synchronized (lock) {

                if (list.size() > 0) {
                    try {

                        lock.wait();

                        System.out.println(String.format("%s, 等待消费", Thread.currentThread().getName()));

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                double random = Math.random();

                System.out.println(String.format("%s value=%s", Thread.currentThread().getName(), random));

                list.add(random);

                lock.notify();
            }

        }

    }

    public static void main(String[] args) {

        Thread pushThread = new Thread(Test6::push);
        pushThread.setName("push");
        pushThread.start();

        Thread[] popThreads = new Thread[10];

        for (int i = 0; i < popThreads.length; i++) {

            popThreads[i] = new Thread(Test6::pop);
            popThreads[i].setName(String.valueOf(i));
            popThreads[i].start();

        }

    }

}

/**
 * 假死情况示例
 */
class Test6_2 {

    private static Object lock = new Object();

    private static List<Double> list = new ArrayList<>();

    private static void pop() {

        while (true) {

            synchronized (lock) {

                /**
                 * 改成 while 将不会出现 Test6 异常，但会出现假死情况
                 */
                while (list.size() == 0) {
                    try {

                        lock.wait();

                        System.out.println(String.format("%s, 等待生产", Thread.currentThread().getName()));

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(String.format("%s pop value=%s", Thread.currentThread().getName(), list.get(0)));

                list.remove(0);

                lock.notify();

            }

        }

    }

    private static void push() {

        while (true) {

            synchronized (lock) {

                if (list.size() > 0) {
                    try {

                        lock.wait();

                        System.out.println(String.format("%s, 等待消费", Thread.currentThread().getName()));

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                double random = Math.random();

                System.out.println(String.format("%s value=%s", Thread.currentThread().getName(), random));

                list.add(random);

                lock.notify();
            }

        }

    }

    public static void main(String[] args) {

        Thread pushThread = new Thread(Test6_2::push);
        pushThread.setName("push");
        pushThread.start();

        Thread[] popThreads = new Thread[10];

        for (int i = 0; i < popThreads.length; i++) {

            popThreads[i] = new Thread(Test6_2::pop);
            popThreads[i].setName(String.valueOf(i));
            popThreads[i].start();

        }

    }

}

/**
 * 正确例子
 */
class Test6_3 {

    private static Object lock = new Object();

    private static List<Double> list = new ArrayList<>();

    private static void pop() {

        while (true) {

            synchronized (lock) {

                /**
                 * 改成 while 将不会出现 Test6 异常，但会出现假死情况
                 */
                while (list.size() == 0) {
                    try {

                        lock.wait();

                        System.out.println(String.format("%s, 等待生产", Thread.currentThread().getName()));

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(String.format("%s pop value=%s", Thread.currentThread().getName(), list.get(0)));

                list.remove(0);

                lock.notifyAll();

            }

        }

    }

    private static void push() {

        while (true) {

            synchronized (lock) {

                while (list.size() > 0) {
                    try {

                        lock.wait();

                        System.out.println(String.format("%s, 等待消费", Thread.currentThread().getName()));

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                double random = Math.random();

                System.out.println(String.format("%s value=%s", Thread.currentThread().getName(), random));

                list.add(random);

                lock.notifyAll();
            }

        }

    }

    public static void main(String[] args) {

        Thread pushThread = new Thread(Test6_3::push);
        pushThread.setName("push");
        pushThread.start();

        Thread[] popThreads = new Thread[10];

        for (int i = 0; i < popThreads.length; i++) {

            popThreads[i] = new Thread(Test6_3::pop);
            popThreads[i].setName(String.valueOf(i));
            popThreads[i].start();

        }

    }


}
