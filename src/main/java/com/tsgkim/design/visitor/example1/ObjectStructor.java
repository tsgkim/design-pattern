package com.tsgkim.design.visitor.example1;

import java.util.ArrayList;
import java.util.List;

public class ObjectStructor {
    private List<Node> list = new ArrayList<>();
    public void action(Visitor visitor){
        for (Node node : list) {


            node.accept(visitor);
        }
    }

    public void add(Node node){
        list.add(node);
    }
}
