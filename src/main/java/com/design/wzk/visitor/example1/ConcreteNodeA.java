package com.design.wzk.visitor.example1;

public class ConcreteNodeA implements Node {
    @Override
    public void accept(Visitor visitor) {
        visitor.visitor(this);
    }
}
