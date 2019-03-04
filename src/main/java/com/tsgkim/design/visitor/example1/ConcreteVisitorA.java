package com.tsgkim.design.visitor.example1;

public class ConcreteVisitorA implements Visitor {
    @Override
    public void visitor(ConcreteNodeA concreteNodeA) {
        //具体处理过程写在这里面
        System.out.println("ConcreteVisitorA 处理 concreteNodeA");
    }

    @Override
    public void visitor(ConcreteNodeB concreteNodeB) {

        //具体处理过程写在这里面
        System.out.println("ConcreteVisitorA 处理 concreteNodeB");
    }
}
