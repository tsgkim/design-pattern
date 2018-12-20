package com.tsgkim.chapter2.string;

import org.junit.Test;

/**
 *
 * @author: shiguang.tu
 * @create: 2018/11/22 8:54 PM
 */
public class Test1 {

    public void say(String value) {

        /**
         * JVM 中具有 String 常量池缓存功能，如果 value 相同，myTest() 中的 thread1 和 thread2 都持有相同的锁，会造成另外一个线程无法执行
         */
        synchronized (value) {

            while (true) {
                System.out.println(String.format("value=%s, thread=%s", value, Thread.currentThread().getName()));
            }
        }

    }

    public void say2(Object object) {

        /**
         * object 也必须不同值才能正常执行同步代码块
         */
        synchronized (object) {

            while (true) {
                System.out.println(String.format("value=%s, thread=%s", object, Thread.currentThread().getName()));
            }
        }

    }

    @Test
    public void myTest() {

        Test1 test1 = new Test1();

        Thread thread1 = new Thread(() -> test1.say("11"));
        thread1.setName("A");

        Thread thread2 = new Thread(() -> test1.say("11"));
        thread2.setName("B");

        thread1.start();
        thread2.start();

    }

    @Test
    public void myTest2() {

        Test1 test1 = new Test1();

        Thread thread1 = new Thread(() -> test1.say2(1));
        thread1.setName("A");

        Thread thread2 = new Thread(() -> test1.say2(1));
        thread2.setName("B");

        thread1.start();
        thread2.start();

    }

    @Test
    public void myTest3() {

        Test1 test1 = new Test1();

        Thread thread1 = new Thread(() -> test1.say2(new Object()));
        thread1.setName("A");

        Thread thread2 = new Thread(() -> test1.say2(new Object()));
        thread2.setName("B");

        thread1.start();
        thread2.start();

    }

}
