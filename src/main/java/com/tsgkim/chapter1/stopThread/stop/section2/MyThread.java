package com.tsgkim.chapter1.stopThread.stop.section2;

/**
 *
 * @author: shiguang.tu
 * @create: 2018/8/9 下午11:47
 */
public class MyThread extends Thread {

    /**
     * 实际 stop() 线程不需要显示捕获，该方法已经作废，
     * 1. 如果强制让线程停止则有可能使一些清理性的工作得不到完成
     * 2. 对锁定的对象进行解锁，导致数据得不到同步处理，出现数据不一致问题
     */
    @Override
    public void run() {

        try {

            this.stop();

        } catch (ThreadDeath e){

            System.out.println("捕获 stop 停止线程异常");
            e.printStackTrace();
        }


    }
}
