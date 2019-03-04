package com.tsgkim.design.visitor.example1;

public class ConcreteNodeB implements Node {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitor(this);
    }
}
