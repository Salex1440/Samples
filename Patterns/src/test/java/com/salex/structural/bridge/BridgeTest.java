package com.salex.structural.bridge;

import org.junit.jupiter.api.Test;

class BridgeTest {

    @Test
    public void test() {
        Implementor implementor = new ConcreteImplementor();
        Abstraction abstraction = new ConcreteAbstraction(implementor);

        abstraction.doOperation();
    }

}