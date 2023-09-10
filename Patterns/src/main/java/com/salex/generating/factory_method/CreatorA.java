package com.salex.generating.factory_method;

public class CreatorA implements Creator {
    @Override
    public Product factoryMethod() {
        return new ProductA();
    }
}
