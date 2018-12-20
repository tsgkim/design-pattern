package com.tsgkim.chapter2.dirtyRead;

/**
 * 多线程赋值，取值都要同步实例变量
 *
 * @author: shiguang.tu
 * @create: 2018/11/22 11:53 AM
 */
public class Test1 {

    private String name = "张三";
    private String password = "123456";

    public void setParam(String name, String password) throws InterruptedException {

        this.name = name;

        Thread.sleep(5000);

        this.password = password;

    }

    public String getPassword() {
        return password;
    }

    /**
     * 赋值同步，这里 synchronized 实际上是将对象上锁
     */
    synchronized public void setParam2(String name, String password) throws InterruptedException {

        this.name = name;

        Thread.sleep(5000);

        this.password = password;

    }

    /**
     * 取值同步，这里 synchronized 实际上是将对象上锁
     */
    synchronized public String getPassword2() {
        return password;
    }

    public String getName() {
        return name;
    }

    /**
     * 脏读情况
     */
    public static void main(String[] args) throws InterruptedException {

        Test1 test1 = new Test1();

        System.out.println(String.format("name=%s, password=%s", test1.getName(), test1.getPassword()));

        new Thread(() -> {
            try {
                test1.setParam("李四", "654321");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(2000);

        System.out.println(String.format("name=%s, password=%s", test1.getName(), test1.getPassword()));

        new Thread(() -> {
            try {
                test1.setParam2("王五", "11111");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(2000);

        System.out.println(String.format("name=%s, password=%s", test1.getName(), test1.getPassword2()));



    }


}
