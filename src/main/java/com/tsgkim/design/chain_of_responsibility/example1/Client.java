package com.tsgkim.design.chain_of_responsibility.example1;

import java.util.ArrayList;
import java.util.Random;

public class Client {
    public static void main(String[] args) {
        // 随机挑选几个女性
        Random rand = new Random();
        ArrayList<IWoman> arrayList = new ArrayList();
        for (int i = 0; i < 5; i++) {
            arrayList.add(new Woman(rand.nextInt(4), "我要出去逛街"));
        }
        // 定义三个请示对象

        IHandle2 father = new Father();
        IHandle2 husband = new Husband();
        IHandle2 son = new Son();
        // 设置请示顺序

        father.setNext(husband);
        husband.setNext(son);
        for (IWoman woman : arrayList) {
            father.handleMessage(woman);
        }
    }
}
