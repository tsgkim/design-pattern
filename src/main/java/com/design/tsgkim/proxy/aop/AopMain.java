package com.design.tsgkim.proxy.aop;

public class AopMain {

    public static void main(String[] args) throws Exception {

        /**
         * 不能用这种方式，不能计算出接口耗时，要交给工厂(IOC)管理，工厂能将计算接口耗时方法逻辑加进去
         *
         * 所以 AOP 是依赖于 IOC
         *
         */
        //MyTest myTest = new MyTest();
        //myTest.helloWorld();

        TsgApplicationContext tsgApplicationContext = new TsgApplicationContext();

        PointCut pointCut = new PointCut();
        pointCut.setClassNamePattern("com.design.tsgkim.proxy.aop.MyTest");
        pointCut.setMethodNamePattern("helloWorld");

        Aspect aspect = new Aspect();
        aspect.setAdvise(new ExecuteTimeAdvise());
        aspect.setPointCut(pointCut);

        tsgApplicationContext.setAspect(aspect);

        tsgApplicationContext.registerBeanDefinition("myTest", MyTest.class);

        MyTest myTest = (MyTest) tsgApplicationContext.getBean("myTest");
        myTest.helloWorld();

    }

}
