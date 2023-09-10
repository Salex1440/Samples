package com.salex.generating.abstract_factory.model;

public class ProductB2 implements ProductB {
    @Override
    public void interact(ProductA productA) {
        System.out.println(this.getClass() + " interacted with " + productA.getClass());
    }
}
