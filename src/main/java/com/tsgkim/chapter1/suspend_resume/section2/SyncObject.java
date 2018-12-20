package com.tsgkim.chapter1.suspend_resume.section2;

import org.junit.Test;

/**
 *
 * @author: shiguang.tu
 * @create: 2018/8/10 上午12:59
 */
public class SyncObject {

    String name="1";
    String password="111";

    synchronized public void print(String name, String password) {

        this.name = name;

        System.out.println(String.format("name=%s, password=%s", name, password));

        if ("a".equals(Thread.currentThread().getName())) {

            System.out.println("a 线程造成公共的同步对象独占，其它线程无法访问公共同步对象");
            Thread.currentThread().suspend();

        }

        this.password = password;

        System.out.println("End execute print()");

    }

    @Override
    public String toString() {
        return "name=" + name + ", password=" + password;
    }

    /**
     * syncObject 被 thread1 独占，其它线程无法访问
     */
    @Test
    public void myTest() throws InterruptedException {

        final SyncObject syncObject = new SyncObject();

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                syncObject.print("张三", "123456");
            }
        };

        thread1.setName("a");
        thread1.start();

        Thread.sleep(2000);

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                syncObject.print("李四", "654321");
            }
        };

        thread2.start();

        // 因为线程暂停导致数据不同步
        new Thread(() -> System.out.println(syncObject.toString())).start();

    }

}
