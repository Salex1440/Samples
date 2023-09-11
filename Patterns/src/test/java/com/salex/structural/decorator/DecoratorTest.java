package com.salex.structural.decorator;

import org.junit.jupiter.api.Test;

class DecoratorTest {

    @Test
    public void test() {
        Decorator decorator = new ServiceDecorator(new ServiceImpl());

        decorator.bar();
    }

}