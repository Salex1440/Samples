package com.salex.behavioral.visitor;

public class GetType implements Visitor {
    private String type;
    @Override
    public void visit(A a) {
        System.out.println("A: " + a.getClass());
    }

    @Override
    public void visit(B b) {
        System.out.println("B: " + b.getClass());
    }
}
