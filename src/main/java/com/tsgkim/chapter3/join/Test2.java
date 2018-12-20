package com.tsgkim.chapter3.join;

/**
 * @author: shiguang.tu
 * @create: 2018/11/29 9:54 AM
 */
public class Test2 {

    public static void main(String[] args) throws InterruptedException {


        Thread thread1 = new Thread(() -> {

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

        Thread thread2 = new Thread(() -> {

            thread1.start();

            /**
             * join() 碰到 interrupt() 会打印异常，但 thread1() 还是正常执行
             */
            try {
                thread1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("thread1 执行完毕之后打印");

        });

        thread2.start();

        Thread.sleep(5000);

        new Thread(() -> thread2.interrupt()).start();
    }
}
