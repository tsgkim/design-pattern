package com.tsgkim.timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 生产者每秒产生 500 个随机数，放入数据池中，50个消费者同时从数据池中取数据，统计某一时刻消费者一共取出了多少个数字，并计算数字总和
 *
 * @author: shiguang.tu
 * @create: 2018/12/5 11:14 AM
 */
public class Test2 {

    private static ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();
    private static ConcurrentHashMap<Integer, String> values = new ConcurrentHashMap<>();

    private static void myCustomer() {

        while (true) {

            values.put(queue.poll(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取指定时间取出了多少个数字
     *
     * @param date
     * @return
     */
    public static int countNumberByTime(String date) {

        int countNumber = 0;

        Iterator<Map.Entry<Integer, String>> iterator = values.entrySet().iterator();

        while (iterator.hasNext()) {

            Map.Entry<Integer, String> next = iterator.next();

            if (next.getValue().equals(date)) {
                ++countNumber;
            }

        }

        return countNumber;

    }

    /**
     * 获取指定时间的总和
     *
     * @param date
     * @return
     */
    public static int countValueByTime(String date) {

        int countValue = 0;

        Iterator<Map.Entry<Integer, String>> iterator = values.entrySet().iterator();

        while (iterator.hasNext()) {

            Map.Entry<Integer, String> next = iterator.next();

            if (next.getValue().equals(date)) {
                countValue += next.getKey().byteValue();
            }

        }

        return countValue;

    }

    public static void main(String[] args) throws InterruptedException {

        TimerTask timerTask = new TimerTask() {

            @Override
            public void run() {
                for (int i = 0; i < 500; i++) {
                    queue.add(new Random().nextInt(100));
                }
                System.out.println(String.format("queue=%s", queue.toString()));
                System.out.println("生产完毕。");
            }

        };

        new Timer().schedule(timerTask, 0, 1000);

        Thread.sleep(3000);

        System.out.println("消费者开始消费");

        for (int i = 0; i < 50; i++) {
            new Thread(Test2::myCustomer).start();
        }

        Thread.sleep(2000);

        System.out.println(String.format("values=%s", values.toString()));

        String date = "2018-12-05 12:07:54";

        System.out.println(String.format("%s 取出了 %s 个数，总和为 %s",
                date,
                Test2.countNumberByTime(date),
                Test2.countValueByTime(date)));

    }


}
