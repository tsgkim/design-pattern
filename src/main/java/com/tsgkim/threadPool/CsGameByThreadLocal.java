package com.tsgkim.threadPool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author: shiguang.tu
 * @create: 2018/12/3 11:35 AM
 */
public class CsGameByThreadLocal {

    /**
     * 初始子弹数
     */
    private static final Integer BULLET_NUMBER = 1500;

    /**
     * 初始杀敌数
     */
    private static final Integer KILL_NUMBER = 0;

    /**
     * 初始生命数
     */
    private static final Integer LIFE_NUMBER = 10;

    /**
     * 初始玩家数
     */
    private static final Integer PLAYER_NUMBER = 10;

    /**
     * 随机数展示不同对象的数据
     */
    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    /**
     * 初始子弹数 by ThreadLocal THREAD_LOCAL
     */
    private static final ThreadLocal<Integer> BULLET_NUMBER_THREAD_LOCAL = ThreadLocal.withInitial(() -> BULLET_NUMBER);

    /**
     * 初始杀敌数
     */
    private static final ThreadLocal<Integer> KILL_NUMBER_THREAD_LOCAL = ThreadLocal.withInitial(() -> KILL_NUMBER);

    /**
     * 初始生命数
     */
    private static final ThreadLocal<Integer> LIFE_NUMBER_THREAD_LOCAL = ThreadLocal.withInitial(() -> LIFE_NUMBER);

    private static void myRun() {

        System.out.println(String.format("bullets=%s, kills=%s, life=%s, thread=%s",
                BULLET_NUMBER_THREAD_LOCAL.get() - RANDOM.nextInt(BULLET_NUMBER),
                KILL_NUMBER_THREAD_LOCAL.get() + RANDOM.nextInt(PLAYER_NUMBER / 2),
                LIFE_NUMBER_THREAD_LOCAL.get() - RANDOM.nextInt(LIFE_NUMBER),
                Thread.currentThread().getName()));

        BULLET_NUMBER_THREAD_LOCAL.remove();
        KILL_NUMBER_THREAD_LOCAL.remove();
        LIFE_NUMBER_THREAD_LOCAL.remove();

    }

    public static void main(String[] args) {

        ExecutorService executorService = new ThreadPoolExecutor(
                5,
                30,
                0,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(10),
                new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        for (int i = 0; i < PLAYER_NUMBER; i++) {

            executorService.execute(CsGameByThreadLocal::myRun);

        }

        executorService.shutdown();

    }

}
