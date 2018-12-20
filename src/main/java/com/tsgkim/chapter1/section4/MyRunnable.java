package com.tsgkim.chapter1.section4;

import com.tsgkim.chapter1.section1.MyThread;
import org.junit.Test;

/**
 * Study:
 *
 * @Description:
 * @author: shiguang.tu
 * @create: 17/10/20 下午11:55
 **/
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("运行中！");
    }

    /**
     * 函数式接口写法
     */
    private static void myRun() {
        System.out.println("运行中！");
    }

    /**
        Thread implements Runnable
        Thread 构造方法中 可传入 Runnable 对象
        ==》可以将一个 Thread 对象中的 run() 方法交由其它线程进行调用
     */
    @Test
    public void myTest() {
        Runnable runnable = new MyRunnable();
        Thread thread1 = new Thread(runnable);
        thread1.start();

        Thread thread2 = new MyThread();
        Thread thread3 = new Thread(thread2);
        thread3.start();

        System.out.println("运行结束！");
    }

    @Test
    public void myTestByLambda() {

        Thread thread = new Thread(MyRunnable::myRun);
        thread.start();
        System.out.println(thread.getName());

        Thread thread1 = new Thread(thread);
        thread1.start();
        System.out.println(thread.getName());

    }
}

