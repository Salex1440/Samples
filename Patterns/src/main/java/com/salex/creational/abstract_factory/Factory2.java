package com.salex.creational.abstract_factory;

import com.salex.creational.abstract_factory.model.ProductA;
import com.salex.creational.abstract_factory.model.ProductA2;
import com.salex.creational.abstract_factory.model.ProductB;
import com.salex.creational.abstract_factory.model.ProductB2;

public class Factory2 extends AbstractFactory {
    @Override
    public ProductA createProductA() {
        return new ProductA2();
    }

    @Override
    public ProductB createProductB() {
        return new ProductB2();
    }
}
