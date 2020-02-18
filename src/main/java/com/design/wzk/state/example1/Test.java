package com.design.state.example1;

public class Test {
    public static void main(String[] args) {
        Hero hero = new Hero();
        hero.startRun();
        hero.setState(Hero.SPEED_UP);
        try {
            Thread.sleep(5000);
            hero.setState(Hero.SPEED_DOWN);
            Thread.sleep(5000);
            hero.setState(Hero.SWIM);
            Thread.sleep(5000);
            hero.stopRun();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
