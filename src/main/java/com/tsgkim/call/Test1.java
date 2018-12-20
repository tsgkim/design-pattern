package com.tsgkim.call;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author: shiguang.tu
 * @create: 2018/12/9 9:51 PM
 */
public class Test1 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,
                20,
                0,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(16),
                new ThreadFactoryBuilder().setNameFormat("tsgkim-pool-%d").build(),
                new ThreadPoolExecutor.AbortPolicy());

        //创建 Callable 任务
        FutureTask<String> futureTask = new FutureTask((Callable<String>) () -> {
            System.out.println("Hello world!");
            //do something
            return "Hello";
        });

        threadPoolExecutor.submit(futureTask);

        threadPoolExecutor.shutdown();

        Thread.sleep(2000);

        System.out.println(futureTask.isDone());

        System.out.println(futureTask.get());


    }


}
