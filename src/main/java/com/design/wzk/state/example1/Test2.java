package com.design.state.example1;

public class Test2 {
    public static void main(String[] args) {
        Hero2 hero = new Hero2();
        hero.startRun();
        hero.setState(Hero2.SPEED_UP);
        try {
//            Thread.sleep(5000);
            hero.setState(Hero2.SPEED_DOWN);
//            Thread.sleep(5000);
            hero.setState(Hero2.SWIM);
            Thread.sleep(5000);
            hero.stopRun();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
