package com.salex.generating.abstract_factory;

import com.salex.generating.abstract_factory.model.ProductA;
import com.salex.generating.abstract_factory.model.ProductA1;
import com.salex.generating.abstract_factory.model.ProductB;
import com.salex.generating.abstract_factory.model.ProductB1;

public class Factory1 extends AbstractFactory {
    @Override
    public ProductA createProductA() {
        return new ProductA1();
    }

    @Override
    public ProductB createProductB() {
        return new ProductB1();
    }
}
