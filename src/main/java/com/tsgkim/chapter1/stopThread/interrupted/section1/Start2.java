package com.tsgkim.chapter1.stopThread.interrupted.section1;

/**
 *
 * @author: shiguang.tu
 * @create: 2018/8/4 下午8:29
 */
public class Start2 {

    /**
     * interrupted()
     *      测试当前线程是否已经中断。线程的中断状态由该方法清除，如果连续两次调用该方法，则第二次调用将返回 false (第一次调用已清除了
     *  其中断状态之后，且第二次调用检验完中断状态前，当前线程再次中断的情况除外)
     *
     */
    public static void main(String[] args) {

        Thread.currentThread().interrupt();

        System.out.println(String.format("threadName = %s, interrupted = %s", Thread.currentThread().getName(), Thread.interrupted()));
        System.out.println(String.format("threadName = %s, interrupted = %s", Thread.currentThread().getName(), Thread.interrupted()));

    }


}
