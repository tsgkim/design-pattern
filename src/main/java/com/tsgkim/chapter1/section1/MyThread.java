package com.tsgkim.chapter1.section1;

import org.junit.Test;

/**
 *
 * Study:
 *      多线程实现两种方式：1. extends Thread  2. implements Runnable
 *
 *      Tread结构类：
 *          public class Thread implements Runnable
 *      ==》Thread 类实现了 Runnable 接口
 *          继承 Thread 类局限性是 不支持多继承 ， 为支持多继承，可以实现 Runnalbe 接口
 *
 * @Description:
 * @author: shiguang.tu
 * @create: 17/10/18 下午11:33
 **/
public class MyThread extends Thread  {

    @Override
    public void run() {
        super.run();
        System.out.println("MyThread");
    }

    /**
     * 使用多线程技术时，代码运行结果与代码执行顺序或者调用顺序无关
     * 有可能先打印 运行结束  再打印 MyThread
     */
    @Test
    public void myRun() {

        MyThread myThread = new MyThread();

        // 如果多次调用 start() 会抛出异常  Exception in thread "main" java.lang.IllegalThreadStateException
        //for (int i=0; i<20;i++){
        //    myThread.start();
        //}

        myThread.start();
        System.out.println("运行结束");

    }

    @Test
    public void myLambdaTest() {

        /**
         * 函数式接口写法
         */
        Runnable runnable = () -> System.out.println("Hello world!");

        runnable.run();

        Thread thread = new Thread(() -> System.out.println("Hello world!"));

        thread.start();

    }
}
