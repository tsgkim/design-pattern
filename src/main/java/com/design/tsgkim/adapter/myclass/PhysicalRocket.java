package com.design.tsgkim.adapter.myclass;

/**
 * target:
 *      适配本类满足 {@link RocketSim} 功能
 *
 * 类似 {@link RocketSim} 的功能，方法并不完全匹配 {@link RocketSim}
 *
 * @author: shiguang.tu
 * @create: 2019/2/26 10:52 PM
 */
public class PhysicalRocket {

    /**
     * 获取火箭的质量
     */
    public double getMass(double t) {
        // 走自己的逻辑，假设最后返回 1D
        return 1D;
    }

    /**
     * 获取火箭产生的推力
     */
    public double getThrust(double time) {
        // 走自己的逻辑，假设最后返回 2D
        return 2D;
    }

    /**
     * 获取发射时间
     */
    public double getBurnTime() {
        // 走自己的逻辑，假设最后返回 3D
        return 3D;
    }

}