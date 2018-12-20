package com.tsgkim.chapter1.stopThread.throwException;

/**
 *
 * @author: shiguang.tu
 * @create: 2018/8/4 下午8:26
 */
public class MyThread extends Thread {

    @Override
    public void run() {

        try {

            for (int i = 0; i < 5000; i++) {

                // 下面两个作用一样
                //if (isInterrupted()) {
                if (interrupted()) {

                    System.out.println("我是 for 里面的代码，我的线程停止了，但是如果我这个 for 下面还有代码，还可以继续运行");

                    throw new InterruptedException();

                }

                System.out.println(String.format("i = %s", i));

            }

            // 如果 for 下面还有代码，还会继续执行，如果不然其执行，可以手动在 for 里面抛异常解决
            System.out.println("我是 for 下面继续运行的代码，线程并未停止");

        } catch (InterruptedException e) {
            System.out.println("为了不执行 for 后续代码，我只能抛异常终止后面的运行了");
        }



    }
}
