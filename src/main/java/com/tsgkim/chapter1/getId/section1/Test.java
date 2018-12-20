package com.tsgkim.chapter1.getId.section1;

/**
 *
 * @author: shiguang.tu
 * @create: 2018/8/4 下午8:19
 */
public class Test {

    public static void main(String[] args) {

        Thread thread = Thread.currentThread();
        System.out.println(String.format("Thread name = %s, id = %s", thread.getName(), thread.getId()));

    }

}
