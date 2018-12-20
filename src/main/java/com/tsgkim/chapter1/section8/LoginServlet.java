package com.tsgkim.chapter1.section8;

import org.junit.Test;

/**
 * 模拟登录
 *
 * @author: shiguang.tu
 * @create: 2018/7/30 下午8:50
 */
public class LoginServlet {

    private static String userNameRef;
    private static String passwordRef;

    private static final String CHECK_USER_NAME_FLAG = "a";

    /**
     * 对比加上 synchronized 和不加上 synchronized 结果
     * static 方法由类拥有，所以 synchronized static 方法 实际上和 synchronized(LoginServlet.class) 效果一致
     */
    public static void doPostError(String userName, String password, String threadName) {

        myCheck(userName, password, threadName);

    }

    synchronized public static void doPostTrueOne(String userName, String password, String threadName) {

        myCheck(userName, password, threadName);

    }

    public static void doPostTrueTwo(String userName, String password, String threadName) {

        synchronized (LoginServlet.class) {
            myCheck(userName, password, threadName);
        }

    }

    private static void myCheck(String userName, String password, String threadName) {

        userNameRef = userName;

        if (CHECK_USER_NAME_FLAG.equals(userName)) {
            try {
                Thread.sleep(5000);
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        passwordRef = password;

        System.out.println(String.format("userNameRef = %s, passwordRef = %s, threadName = %s",
                userNameRef, passwordRef, threadName));
    }

    /**
     * 必须用 main 才能执行程序，下面 myTest() 无法执行
     * @param args
     */
    public static void main(String[] args) {

        Thread threadA = new Thread(() -> LoginServlet.doPostError("a", "aa", "A"));
        Thread threadB = new Thread(() -> LoginServlet.doPostError("b", "bb", "B"));

        threadA.start();
        threadB.start();

        Thread threadC = new Thread(() -> LoginServlet.doPostTrueOne("c", "cc", "C"));
        Thread threadD = new Thread(() -> LoginServlet.doPostTrueOne("d", "dd", "D"));

        threadC.start();
        threadD.start();

        Thread threadE = new Thread(() -> LoginServlet.doPostTrueTwo("e", "ee", "E"));
        Thread threadF = new Thread(() -> LoginServlet.doPostTrueTwo("f", "ff", "F"));

        threadE.start();
        threadF.start();

    }

    @Test
    public void myTest() {

        Thread threadA = new Thread(() -> LoginServlet.doPostError("a", "aa", "A"));

        Thread threadB = new Thread(() -> LoginServlet.doPostError("a", "aa", "B"));

        threadA.start();
        threadB.start();

    }

}
