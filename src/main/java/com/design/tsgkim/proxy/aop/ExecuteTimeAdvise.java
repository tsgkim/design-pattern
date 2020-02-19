package com.design.tsgkim.proxy.aop;

import java.lang.reflect.Method;

public class ExecuteTimeAdvise implements Advise {

    @Override
    public Object invoke(Object target, Method method, Object[] args) throws Exception {

        long startTime = System.currentTimeMillis();

        Object invoke = method.invoke(target, args);

        long spendTime = System.currentTimeMillis() - startTime;

        System.out.println(String.format("%s.%s 耗时 %s 毫秒 | %s 秒",
                target.getClass().getName(), method.getName(), spendTime, spendTime / 1000));

        return invoke;

    }


}
