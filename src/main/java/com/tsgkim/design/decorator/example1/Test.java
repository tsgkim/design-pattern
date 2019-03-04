package com.tsgkim.design.decorator.example1;

public class Test {
    public static void main(String[] args) {
        Human human = new Human();
        human.show();
        System.out.println("=====");
        WearHuman wearHuman = new WearHuman(human);
        wearHuman.show();
        System.out.println("=======");
        JewelleyHunam jewelleyHunam = new JewelleyHunam(wearHuman);
        jewelleyHunam.show();
    }
}
