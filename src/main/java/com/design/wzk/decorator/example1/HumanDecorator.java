package com.design.decorator.example1;

public class HumanDecorator implements IHuman{
    //定义了装饰类去继承公共接口，实现一开始实现初始接口实现的方法
    protected   IHuman ihuman;

    public HumanDecorator(IHuman ihuman){
        this.ihuman = ihuman;
    }
    @Override
    public void show() {
        ihuman.show();
    }
}
