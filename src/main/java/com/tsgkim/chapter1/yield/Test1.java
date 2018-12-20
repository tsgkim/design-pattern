package com.tsgkim.chapter1.yield;

import org.junit.Test;

/**
 * @author: shiguang.tu
 * @create: 2018/11/21 7:50 PM
 */
public class Test1 {

    /**
     * {@link Thread#yield()} 放弃当前 CPU 资源， 放弃时间不确定
     */
    private static void myRun() {

        int count = 0;

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000; ) {
            Thread.yield();
            count = count + (i++);

        }

        long endTime = System.currentTimeMillis();

        System.out.println(String.format("Spend time=%s", (endTime - startTime)));

    }

    @Test
    public void myTest() {

        new Thread(Test1::myRun).start();

    }


}
