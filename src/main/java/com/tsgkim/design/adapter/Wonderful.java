package com.tsgkim.design.adapter;

/**
 * 适配 {@link RocketSim} 类
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
