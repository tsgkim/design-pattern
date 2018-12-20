package com.tsgkim.chapter3.waitAndNotify;

/**
 * 
 * @author: shiguang.tu
 * @create: 2018/11/27 5:28 PM
 */
public class Test1 {

    /**
     * 没有对代码块加锁，wait() 无效
     */
    public static void main(String[] args) throws InterruptedException {

        String ss = "ss";
        ss.wait();

    }

}

class Test_1 {

    /**
     * 必须对 wait(); 对应的对象加锁，对应的对象才能使用 wait()，不是对应的对象加锁还是报异常
     */
    public static void main(String[] args) throws InterruptedException {

        String ss = "ss";

        synchronized (ss) {
            ss.wait();
        }

    }

}
