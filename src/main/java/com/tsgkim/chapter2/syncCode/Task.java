package com.tsgkim.chapter2.syncCode;

/**
 * @author: shiguang.tu
 * @create: 2018/11/22 2:53 PM
 */
public class Task {

    private String value;

    public void doLongTimeTask(String param) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(String.format("同步代码块前 threadName=%s, value=%s, param=%s",
                Thread.currentThread().getName(), value, param));

        /**
         * 当前线程在执行 代码1 时，其余等待线程不会跳过 代码1 而去执行 代码2
         */
        //***************** 代码1 *****************/
        synchronized (this) {

            value = param;

            System.out.println(String.format("同步代码块 threadName=%s, value=%s, param=%s",
                    Thread.currentThread().getName(), value, param));

        }
        //***************** 代码1 *****************/

        /**
         * 代码 2 value 不安全，代码1 锁释放后，马上会被其余等待线程执行 代码1 覆写 value，会导致 代码2 value 不是当前线程设定的值
         */
        //***************** 代码2 *****************/
        System.out.println(String.format("同步代码块后 threadName=%s, value=%s, param=%s",
                Thread.currentThread().getName(), value, param));
        //***************** 代码2 *****************/

    }

}

class CommonUtils {

    public static long beginTime1;
    public static long endTime1;
    public static long beginTime2;
    public static long endTime2;

}

class MyThread1 extends Thread {

    private Task task;
    private String value;

    public MyThread1(Task task, String value) {
        this.task = task;
        this.value = value;
    }

    @Override
    public void run() {

        CommonUtils.beginTime1 = System.currentTimeMillis();
        task.doLongTimeTask(value);
        CommonUtils.endTime1 = System.currentTimeMillis();

    }
}

class MyThread2 extends Thread {

    private Task task;
    private String value;

    public MyThread2(Task task, String value) {
        this.task = task;
        this.value = value;
    }

    @Override
    public void run() {

        CommonUtils.beginTime2 = System.currentTimeMillis();
        task.doLongTimeTask(value);
        CommonUtils.endTime2 = System.currentTimeMillis();

    }
}

class Run {

    public static void main(String[] args) {

        Task task = new Task();

        MyThread1 thread1 = new MyThread1(task, "11");
        thread1.setName("A");
        thread1.start();

        MyThread2 thread2 = new MyThread2(task, "22");
        thread2.setName("B");
        thread2.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Long beginTime = (CommonUtils.beginTime2 < CommonUtils.beginTime1) ? CommonUtils.beginTime2 : CommonUtils.beginTime1;
        Long endTime = (CommonUtils.endTime2 < CommonUtils.endTime1) ? CommonUtils.endTime2 : CommonUtils.endTime1;

        System.out.println(String.format("耗时:%ss", ((endTime - beginTime) / 1000)));
    }

}


