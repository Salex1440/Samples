package com.salex.generating.factory_method;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CreatorTest {

    @Test
    public void factoryMethodTest() {
        List<Creator> creators = List.of(new CreatorA(), new CreatorB());
        for (Creator creator : creators) {
            System.out.println(creator.factoryMethod());
        }
    }

}