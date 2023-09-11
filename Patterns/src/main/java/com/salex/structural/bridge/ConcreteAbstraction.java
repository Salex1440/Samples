package com.salex.structural.bridge;

public class ConcreteAbstraction extends Abstraction {


    protected ConcreteAbstraction(Implementor implementor) {
        super(implementor);
    }

    @Override
    public void doOperation() {
        implementor.invoke();
    }

}
