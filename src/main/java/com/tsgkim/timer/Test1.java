package com.tsgkim.timer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author: shiguang.tu
 * @create: 2018/12/1 11:06 AM
 */
public class Test1 {

    public static void main(String[] args) throws ParseException {

        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2018-12-01 11:22:00");

        new Timer().schedule(new MyTask(), date);

        //ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1,
        //        new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d").daemon(true).build());
        //executorService.scheduleAtFixedRate((Runnable) () -> System.out.println("Hello world!"),initialDelay,period, TimeUnit.HOURS);

    }

}

class MyTask extends TimerTask {

    @Override
    public void run() {
        System.out.println("Hello world!");
    }
}
