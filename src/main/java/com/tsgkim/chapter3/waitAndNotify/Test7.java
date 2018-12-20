package com.tsgkim.chapter3.waitAndNotify;

/**
 *
 *
 * @author: shiguang.tu
 * @create: 2018/11/28 8:58 PM
 */
public class Test7 {

    private boolean isCrossA = false;

    synchronized public void crossA() {

        while (isCrossA == false) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("CrossA");

        isCrossA = false;

        notifyAll();

    }

    synchronized public void crossB() {

        while (isCrossA) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("CrossB");

        isCrossA = true;

        notifyAll();

    }

    public static void main(String[] args) {

        Test7 test7 = new Test7();

        for (int i = 0; i < 10; i++) {

            new Thread(() -> test7.crossA()).start();

            new Thread(() -> test7.crossB()).start();

        }

    }

}
