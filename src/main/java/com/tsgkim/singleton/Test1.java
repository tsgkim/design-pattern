package com.tsgkim.singleton;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 单例模式 恶汉模式 代码正确不存在线程安全问题
 *
 * @author: shiguang.tu
 * @create: 2018/12/1 11:41 AM
 */
public class Test1 {

    private static Test1 test1 = new Test1();

    /**
     * 不能有其它实例变量，因为这种获取方式没有线程同步
     */
    public static Test1 getInstance() {
        return test1;
    }

    public static Test1 getInstance2() {
        return Test1Handle.test1;
    }

    static class Test1Handle {
        private static Test1 test1 = new Test1();
    }

    /**
     * 通过打印 hashcode 看的出只 new 出来一个
     */
    public static void main(String[] args) {

        //Runnable runnable = () -> {
        //
        //    Test1 instance = Test1.getInstance();
        //
        //    System.out.println(String.format("hashcode=%s", instance.hashCode()));
        //};
        //
        //for (int i = 0; i < 10; i++) {
        //    new Thread(runnable).start();
        //}

        Runnable runnable2 = () -> {

            Test1 instance = Test1.getInstance2();

            System.out.println(String.format("hashcode=%s", instance.hashCode()));
        };

        for (int i = 0; i < 10; i++) {
            new Thread(runnable2).start();
        }

    }

}

/**
 * 单例模式 懒汉模式
 */
class Test1_2 {

    private static Test1_2 test1_2;

    private static ReentrantLock reentrantLock = new ReentrantLock();

    /**
     * 线程不安全，不正确例子
     */
    public static Test1_2 getInstance() {

        if (test1_2 == null) {
            test1_2 = new Test1_2();
        }

        return test1_2;
    }

    /**
     * 线程安全 正确例子
     */
    synchronized public static Test1_2 getInstance2() {

        if (test1_2 == null) {
            test1_2 = new Test1_2();
        }

        return test1_2;

    }

    /**
     * 线程安全 正确例子
     */
    synchronized public static Test1_2 getInstance2_2() {

        reentrantLock.lock();

        try {

            if (test1_2 == null) {
                test1_2 = new Test1_2();
            }

            return test1_2;

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }

        return null;
    }

    /**
     * 多线程改进 DCL(Double-checked Locking) 双检查锁 单例模式采取的代码
     * 存在问题：
     *      java 编译器初始化 Test1_2 实例和将对象地址写到 test1_2 不是原子操作，这两个阶段的执行顺序是未定义的，假设某个线程执行
     *  new Test1_2() 时，构造方法还未被调用，编译器只为该对象分配了内存空间并设为默认值，此时另外一个线程调用 getInstance3() 方法，
     *  由于 test1_2 != null，但是此时 service 对象还没有被赋予有效值，从而无法获取未构造完成的对象
     *  解决此问题办法是在 private static Test1_2 test1_2; 加上 volatile
     */
    public static Test1_2 getInstance3() {

        if (test1_2 == null) {

            synchronized (Test1_2.class) {

                if (test1_2 == null) {
                    test1_2 = new Test1_2();
                }

            }

        }

        return test1_2;

    }

    /**
     * 通过打印 hashcode 看的出 new 出来了多个
     */
    public static void main(String[] args) {

        //Runnable runnable1 = () -> {
        //
        //    Test1 instance = Test1_2.getInstance();
        //
        //    System.out.println(String.format("hashcode=%s", instance.hashCode()));
        //};
        //
        //for (int i = 0; i < 10; i++) {
        //     new Thread(runnable1).start();
        //}

        //Runnable runnable2 = () -> System.out.println(String.format("hashcode=%s", Test1_2.getInstance2().hashCode()));
        //
        //for (int i = 0; i < 10; i++) {
        //    new Thread(runnable2).start();
        //}

        Runnable runnable2_2 = () -> System.out.println(String.format("hashcode=%s", Test1_2.getInstance2_2().hashCode()));

        for (int i = 0; i < 10; i++) {
            new Thread(runnable2_2).start();
        }

        //Runnable runnable3 = () -> System.out.println(String.format("hashcode=%s", Test1_2.getInstance3().hashCode()));
        //
        //for (int i = 0; i < 10; i++) {
        //    new Thread(runnable3).start();
        //}

    }
}
