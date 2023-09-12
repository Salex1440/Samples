package com.salex.behavioral.visitor;

public class A implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
