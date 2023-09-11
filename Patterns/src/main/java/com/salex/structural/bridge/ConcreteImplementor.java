package com.salex.structural.bridge;

public class ConcreteImplementor implements Implementor {

    @Override
    public void invoke() {
        System.out.println("FOO BAR");
    }

}
