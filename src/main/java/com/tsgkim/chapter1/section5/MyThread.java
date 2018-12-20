package com.tsgkim.chapter1.section5;

/**
 * Study:
 *
 * @Description:
 * @author: shiguang.tu
 * @create: 17/10/21 上午12:32
 **/
public class MyThread extends Thread {

    private int count = 5;

    public MyThread(String name) {
        // 设置线程名称
        this.setName(name);
    }

    @Override
    public void run() {
        while (count > 0) {
            count--;
            System.out.println("由" + currentThread().getName() + "计算，count=" + count);
        }
    }

    /**
     * 线程变量不共享
     * 此示例并不存在多个线程访问同一个实例变量的情况，所以 count 并不共享
     */
    public static void main(String[] args) {

        MyThread myThread1 = new MyThread("A");
        MyThread myThread2 = new MyThread("B");
        MyThread myThread3 = new MyThread("C");

        myThread1.start();
        myThread2.start();
        myThread3.start();

    }
}
