package com.tsgkim.chapter1.stopThread.interrupted.section1;

import com.tsgkim.chapter1.stopThread.MyThread;

/**
 *
 * @author: shiguang.tu
 * @create: 2018/8/4 下午8:29
 */
public class Start1 {

    /**
     * interrupted()
     *      测试当前线程是否已经中断。线程的中断状态由该方法清除，如果连续两次调用该方法，则第二次调用将返回 false (第一次调用已清除了
     *  其中断状态之后，且第二次调用检验完中断状态前，当前线程再次中断的情况除外)
     *
     *  这个例子，两次都打印 false，interrupted() 判断的当前线程是 main，它从未中断过，所以打印结果是两个 false
     *
     */
    public static void main(String[] args) {

        MyThread myThread = new MyThread();

        myThread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 这里没有中断主线程 main
        myThread.interrupt();

        System.out.println(String.format("threadName = %s, interrupted = %s", Thread.currentThread().getName(), Thread.interrupted()));
        System.out.println(String.format("threadName = %s, interrupted = %s", Thread.currentThread().getName(), Thread.interrupted()));

    }


}
