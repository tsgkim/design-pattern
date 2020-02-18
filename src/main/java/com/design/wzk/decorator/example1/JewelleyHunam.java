package com.design.decorator.example1;

public class JewelleyHunam extends HumanDecorator {
    public JewelleyHunam(IHuman ihuman) {
        super(ihuman);
    }

    public void wearJewel(){
        //编写代码
    }

    @Override
    public void show() {
        ihuman.show();
        //添加了wearJewel方法
        wearJewel();
    }
}
