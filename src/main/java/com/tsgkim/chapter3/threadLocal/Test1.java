package com.tsgkim.chapter3.threadLocal;

/**
 *
 * @author: shiguang.tu
 * @create: 2018/11/29 11:36 AM
 */
public class Test1 {

    public static String value = "A";

    public static ThreadLocal<String> threadLocal = new ThreadLocal();

    public static void main(String[] args) throws InterruptedException {

        threadLocal.set("张三");

        /**
         * 线程里面更改 threadLocal
         */
        Thread thread = new Thread(() -> {

            Test1.value = "B";
            threadLocal.set("李四");

        });

        thread.start();
        thread.join();

        System.out.println(String.format("value=%s, threadLocal=%s", value, threadLocal.get()));

    }


}
