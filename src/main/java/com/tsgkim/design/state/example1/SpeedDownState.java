package com.tsgkim.design.state.example1;

public class SpeedDownState implements RunState {
    @Override
    public void run(Hero2 hero) {
        System.out.println("--------------减速跑动---------------");
        try {
            Thread.sleep(4000);//假设减速持续4秒
        } catch (InterruptedException e) {

        }
        hero.setState(Hero2.COMMON);
        System.out.println("------减速状态结束，变为正常状态------");

    }
}
