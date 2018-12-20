package com.tsgkim.chapter3.join;

/**
 *
 * @author: shiguang.tu
 * @create: 2018/11/29 11:18 AM
 */
public class Test4 extends Thread{

    private Test4_2 test4_2;

    public Test4(Test4_2 test4_2) {
        this.test4_2 = test4_2;
    }

    @Override
    public void run() {

        synchronized (test4_2) {

            System.out.println("Test4 start");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Test4 end");

        }

    }

    /**
     * 都有锁 test4_2  start()，join()，run() 都在竞争锁，所以执行顺序都是不同的
     */
    public static void main(String[] args) throws InterruptedException {

        Test4_2 test4_2 = new Test4_2();

        new Test4(test4_2).start();

        test4_2.start();

        test4_2.join(2000);

        System.out.println("结束");
    }

}

class Test4_2 extends Thread {

    @Override
    synchronized public void run() {

        System.out.println("Test4_2 start");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Test4_2 end");

    }
}

