package com.tsgkim.design.adapter.myentity;

/**
 * 火箭基本类型类
 *
 * target:
 *      希望能够添加一些更加复杂的物理模型，而物理模型由 {@link PhysicalRocket} 提供，所以需要用到对象适配器模式
 *
 * @author: shiguang.tu
 * @create: 2019/2/28 12:18 AM
 */
public class SkyRocket {

    private String name;

    /**
     * 获取火箭的质量
     */
    public double getMass(double t) {
        // 走自己的逻辑，假设最后返回 -1D
        return -1D;
    }

    /**
     * 获取火箭产生的推力
     */
    public double getThrust(double time) {
        // 走自己的逻辑，假设最后返回 -2D
        return -2D;
    }

    /**
     * 获取发射时间
     */
    public double getBurnTime() {
        // 走自己的逻辑，假设最后返回 -3D
        return -3D;
    }

}