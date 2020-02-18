package com.design.wzk.visitor.example1;

public class Test {
    public static void main(String[] args) {
        ObjectStructor objectStructor = new ObjectStructor();
        ConcreteNodeA concreteNodeA = new ConcreteNodeA();
        ConcreteNodeB concreteNodeB = new ConcreteNodeB();
        objectStructor.add(concreteNodeA);
        objectStructor.add(concreteNodeB);
        System.out.println("访问者A访问元素");
        objectStructor.action(new ConcreteVisitorA());
        System.out.println("访问者B访问元素");
        objectStructor.action(new ConcreteVisitorB());
    }
}
