package com.tsgkim.singleton;

/**
 * Q: 字符串 AAA 则输出 3A，字符串为 ABBCCC，则输出 1A2B3C，请用单例模式设计
 *
 * @author: shiguang.tu
 * @create: 2018/12/5 10:16 AM
 */
public class Test2 {

    volatile private static Test2 test2;

    private String str;

    /**
     * 对象不可 new
     */
    private Test2() {

    }

    /**
     * DCL（Double-Checked Locking） 双重检查锁 ：两次 if 空判断
     * volatile 设置 test2 内存可见性，synchronized 同步 new 对象
     */
    public static Test2 getInstance() {

        if (null == test2) {
            synchronized (Test2.class) {
                if (null == test2) {
                    test2 = new Test2();
                }
            }
        }

        return test2;
    }

    public static void main(String[] args) {

        Test2 test2 = Test2.getInstance();

        test2.setStr("ABBCCC");

        String str = test2.getStr();
        int length = str.length();

        char ctr[] = new char[length];
        str.getChars(0, str.length(), ctr, 0);

        String newStr = "";
        for (int i = 0; i < length;) {

            char showChar = ctr[i];
            int startShowIndex = str.indexOf(showChar);
            int lastShowIndex = str.lastIndexOf(showChar);

            i = lastShowIndex + 1;

            newStr += (String.valueOf((lastShowIndex - startShowIndex) + 1)) + String.valueOf(showChar);

        }

        System.out.println(newStr);

    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}