package com.design.tsgkim.adapter.myentity;

/**
 * 对象适配器
 *
 * 使用对象适配器比使用类适配器更加脆弱的原因：
 *     1. {@link Wonderful} 没有提供接口规范，如果 {@link SkyRocket} 变化，可能在编译时无法检测到（有 {@link Override} 可避免此问题）。
 *     2. {@link Wonderful} 需要借助 {@link SkyRocket} 父类访问 {@link SkyRocket#name}，无法保证此变量总是被声明为 protected，
 *          也不能保证 {@link SkyRocket#name} 这个字段符合子类的意图。
 *
 * @author: shiguang.tu
 * @create: 2019/2/28 12:21 AM
 */
public class Wonderful extends SkyRocket {

    private PhysicalRocket physicalRocket;

    public Wonderful(PhysicalRocket physicalRocket) {
        this.physicalRocket = physicalRocket;
    }

    @Override
    public double getMass(double t) {
        return physicalRocket.getMass(1D);
    }

}
