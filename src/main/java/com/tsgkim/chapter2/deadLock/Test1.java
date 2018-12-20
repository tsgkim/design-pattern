package com.tsgkim.chapter2.deadLock;

/**
 *
 * @author: shiguang.tu
 * @create: 2018/11/22 10:08 PM
 */
public class Test1 {

    Object object1 = new Object();
    Object object2 = new Object();

    public void say(String value) {

        if ("a".equals(value)) {

            synchronized (object1) {

                System.out.println(String.format("Thread name=%s", Thread.currentThread().getName()));

                synchronized (object2) {
                    System.out.println("aaaa");
                }

            }

        }

        if ("b".equals(value)) {

            synchronized (object2) {

                System.out.println(String.format("Thread name=%s", Thread.currentThread().getName()));

                synchronized (object1) {
                    System.out.println("bbbb");
                }

            }

        }

    }

    public static void main(String[] args) {

        Test1 test1 = new Test1();

        Thread thread1 = new Thread(() -> test1.say("a"));
        thread1.setName("A");

        Thread thread2 = new Thread(() -> test1.say("b"));
        thread2.setName("B");

        thread1.start();
        thread2.start();

    }



}
