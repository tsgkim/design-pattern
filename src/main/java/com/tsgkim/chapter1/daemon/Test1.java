package com.tsgkim.chapter1.daemon;

/**
 *
 * @author: shiguang.tu
 * @create: 2018/11/22 10:21 AM
 */
public class Test1 {

    private static void myRun() {

        int i = 0;

        while (true) {
            System.out.println(String.format("i=%s, thread name=%s", i++, Thread.currentThread().getName()));
        }

    }

    /**
     * 当最后一个非守护线程结束，守护线程才会结束，GC 就是一个守护线程
     */
    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(Test1::myRun);
        thread.setDaemon(true);
        thread.setName("A");

        thread.start();

        Thread.sleep(1000);

        System.out.println("守护线程 A 结束！");
    }

}
