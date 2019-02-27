package com.tsgkim.design.state.example1;

public class SwimState implements RunState {
    @Override
    public void run(Hero2 hero) {
        System.out.println("--------------不能跑动---------------");
        try {
            Thread.sleep(2000);//假设眩晕持续2秒
        } catch (InterruptedException e) {

        }
        hero.setState(Hero2.COMMON);
        System.out.println("------眩晕状态结束，变为正常状态------");

    }
}
