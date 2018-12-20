package com.tsgkim.chapter1.suspend_resume.section2;

import org.junit.Test;

public class MyPrintln {

    private Integer i = 0;

    /**
     * 程序正常执行
     */
    @Test
    public void myTest() throws InterruptedException {

        Thread thread = new Thread(() -> {

            while (true) {
                i++;
            }

        });

        thread.start();

        Thread.sleep(1000);

        thread.suspend();

        System.out.println(String.format("i=%s", i));

    }

    /**
     * 中断会卡在 System.out.println(String.format("i=%s", i)); 导致 System.out.println("程序中断"); 无法执行
     */
    @Test
    public void myTest2() throws InterruptedException {

        Thread thread = new Thread(() -> {

            while (true) {
                i++;
                System.out.println(String.format("i=%s", i));
            }

        });

        thread.start();

        Thread.sleep(1000);

        thread.suspend();

        System.out.println("程序中断");

    }

}
