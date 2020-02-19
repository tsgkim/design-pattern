package com.design.tsgkim.proxy.aop;

import java.lang.reflect.Method;

public interface Advise {

    Object invoke(Object target, Method method, Object[] args) throws Exception;

}
