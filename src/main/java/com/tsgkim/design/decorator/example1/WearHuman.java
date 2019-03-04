package com.tsgkim.design.decorator.example1;

public class WearHuman extends HumanDecorator {
    public WearHuman(IHuman ihuman) {
        super(ihuman);
    }

    public void wear(){
        //编写代码
    }

    @Override
    public void show() {

        ihuman.show();
        //添加了wear方法
        wear();
    }
}
