package com.tsgkim.chapter1.section7;

import org.junit.Test;

/**
 * Study:
 *
 * @Description:
 * @author: shiguang.tu
 * @create: 17/10/24 下午11:52
 **/
public class MyThread extends Thread {

    private Integer count = 5;

    /**
     * 通过在 run() 方法前加入 synchronized 关键字，使多个线程排队执行 run() 方法
     *
     * 当一个线程在调用 run() 方法之前 先判断是否被上锁，如果上锁，说明当前正在有线程调用 run()，必须等其它线程调用完毕 run() 之后
     * 继续执行 run() 方法
     *
     * 当一个线程要执行 synchronized 代码块，首先会去拿这把锁，能够拿到，就可以执行，不然需要不断尝试去拿这把锁，而且是多个线程同时
     * 都会去争抢这把锁
     *
     * synchronized 可以在任意对象及方法上加锁，加锁代码称之为 互斥区 或 临界区
     *
     * 使用 synchronized 来定义方法，但 synchronized 并不属于方法定义的一部分，因此，synchronized 关键字不能被继承
     */
    @Override
    synchronized public void run() {

        System.out.println("由" + currentThread().getName() + "计算，count=" + (count --) );

    }

    /**
     * 线程安全的共享变量
     */
    @Test
    public void myTest() {

        MyThread myThread = new MyThread();
        Thread a = new Thread(myThread, "A");
        Thread b = new Thread(myThread, "B");
        Thread c = new Thread(myThread, "C");
        Thread d = new Thread(myThread, "D");

        a.start();
        b.start();
        c.start();
        d.start();
    }

    @Test
    public void myTestByLambda() {

        Thread myThread = new Thread(() -> {
            synchronized (count) {
                System.out.println("由" + currentThread().getName() + "计算，count=" + (count --) );
            }
        });

        Thread a = new Thread(myThread, "A");
        Thread b = new Thread(myThread, "B");
        Thread c = new Thread(myThread, "C");
        Thread d = new Thread(myThread, "D");

        a.start();
        b.start();
        c.start();
        d.start();
    }

}
