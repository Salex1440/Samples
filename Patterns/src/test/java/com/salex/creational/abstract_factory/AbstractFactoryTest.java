package com.salex.creational.abstract_factory;

import com.salex.creational.abstract_factory.model.ProductA;
import com.salex.creational.abstract_factory.model.ProductB;
import org.junit.jupiter.api.Test;

class AbstractFactoryTest {

    @Test
    public void test() {
        AbstractFactory factory1 = new Factory1();
        AbstractFactory factory2 = new Factory2();

        ProductA productA1 = factory1.createProductA();
        ProductB productB1 = factory1.createProductB();
        ProductA productA2 = factory2.createProductA();
        ProductB productB2 = factory2.createProductB();

        productB1.interact(productA1);
        productB2.interact(productA2);
    }

}