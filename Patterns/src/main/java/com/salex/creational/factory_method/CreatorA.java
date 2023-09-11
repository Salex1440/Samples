package com.salex.creational.factory_method;

public class CreatorA implements Creator {
    @Override
    public Product factoryMethod() {
        return new ProductA();
    }
}
