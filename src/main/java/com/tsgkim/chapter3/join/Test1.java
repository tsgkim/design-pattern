package com.tsgkim.chapter3.join;

import org.junit.Test;

/**
 * @author: shiguang.tu
 * @create: 2018/11/29 9:41 AM
 */
public class Test1 {

    @Test
    public void myTest() throws InterruptedException {

        Thread thread = new Thread(() -> System.out.println("Hello world!"));

        thread.start();
        thread.join();

        System.out.println("线程执行之后我才执行");

    }

}
