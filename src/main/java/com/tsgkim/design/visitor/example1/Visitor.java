package com.tsgkim.design.visitor.example1;

public interface Visitor {
    void visitor(ConcreteNodeA concreteNodeA);

    void visitor(ConcreteNodeB concreteNodeB);
}
