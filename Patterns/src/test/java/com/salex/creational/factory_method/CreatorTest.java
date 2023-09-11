package com.salex.creational.factory_method;

import org.junit.jupiter.api.Test;

import java.util.List;

class CreatorTest {

    @Test
    public void factoryMethodTest() {
        List<Creator> creators = List.of(new CreatorA(), new CreatorB());
        for (Creator creator : creators) {
            System.out.println(creator.factoryMethod());
        }
    }

}