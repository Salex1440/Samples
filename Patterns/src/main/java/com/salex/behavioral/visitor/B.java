package com.salex.behavioral.visitor;

public class B implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
