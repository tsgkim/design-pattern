package com.design.tsgkim.proxy.aop;

public interface ApplicationContext {

    Object getBean(String beanName) throws Exception;

    void registerBeanDefinition(String beanName, Class<?> beanClass);

    void setAspect(Aspect aspect);

}
