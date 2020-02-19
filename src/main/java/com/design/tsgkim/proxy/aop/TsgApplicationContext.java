package com.design.tsgkim.proxy.aop;

import com.google.common.collect.Maps;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

import java.util.Map;
import java.util.Objects;

public class TsgApplicationContext implements ApplicationContext {

    private Map<String, Class<?>> beanDefinitionMap = Maps.newConcurrentMap();

    private Aspect aspect;

    @Override
    public Object getBean(String beanName) throws Exception {

        Object bean = createBeanInstance(beanName);

        // 不能直接返回这个 bean，要返回工厂加工好的 bean
        bean = proxyBean(bean);

        return bean;

    }

    private Object proxyBean(Object bean) {

        Class<?> beanClass = bean.getClass();

        if (Objects.nonNull(this.aspect)
                && beanClass.getName().equals(aspect.getPointCut().getClassNamePattern())) {

            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(beanClass);
            enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {

                if (method.getName().matches(aspect.getPointCut().getMethodNamePattern())) {
                    return aspect.getAdvise().invoke(bean, method, objects);
                }

                return method.invoke(bean, objects);

            });

            return enhancer.create();

        }

        return bean;

    }

    private Object createBeanInstance(String beanName) throws Exception {
        return this.beanDefinitionMap.get(beanName).newInstance();
    }

    @Override
    public void registerBeanDefinition(String beanName, Class<?> beanClass) {
        this.beanDefinitionMap.put(beanName, beanClass);
    }

    @Override
    public void setAspect(Aspect aspect) {
        this.aspect = aspect;
    }


}
