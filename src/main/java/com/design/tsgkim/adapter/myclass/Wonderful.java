package com.design.tsgkim.adapter.myclass;

/**
 * 适配 {@link RocketSim} 类
 * 类适配器：实现接口，继承需要适配的类，适用于一组方法定义在接口中
 */
public class Wonderful extends PhysicalRocket implements RocketSim {

    private Double time;

    @Override
    public double getMass() {
        /**
         * 调用 {@link PhysicalRocket#getMass(double)} 完成适配
         */
        return getMass(1D);
    }

    @Override
    public double getThrust() {
        /**
         * 调用 {@link PhysicalRocket#getThrust(double)} 完成适配
         */
        return getThrust(2D);
    }

    @Override
    public void setSimTime(double t) {
        /**
         * 走自己的逻辑
         */
        this.time = t;
    }

}
