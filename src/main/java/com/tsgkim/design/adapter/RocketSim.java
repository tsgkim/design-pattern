package com.tsgkim.design.adapter;

/**
 * 火箭仿真接口
 *
 * @author: shiguang.tu
 * @create: 2019/2/26 10:47 PM
 */
public interface RocketSim {

    /**
     * 获取火箭的质量
     */
    double getMass();

    /**
     * 获取火箭产生的推力
     */
    double getThrust();

    /**
     * 更新当前时间
     */
    void setSimTime(double t);

}