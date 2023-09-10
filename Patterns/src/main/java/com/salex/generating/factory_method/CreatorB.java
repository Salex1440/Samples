package com.salex.generating.factory_method;

public class CreatorB implements Creator{
    @Override
    public Product factoryMethod() {
        return new ProductB();
    }
}
