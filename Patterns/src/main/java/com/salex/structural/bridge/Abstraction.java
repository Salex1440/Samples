package com.salex.structural.bridge;

/**
 * структурный шаблон проектирования, который позволяет отделить абстракцию от реализации таким образом,
 * чтобы и абстракцию, и реализацию можно было изменять независимо друг от друга.
 */
public abstract class Abstraction {

    protected final Implementor implementor; // BRIDGE


    protected Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    public abstract void doOperation();

}
