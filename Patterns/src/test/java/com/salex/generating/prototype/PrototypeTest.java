package com.salex.generating.prototype;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrototypeTest {

    @Test
    public void test() {
        Prototype prototype = new PrototypeImpl("prototype");
        Prototype clone = prototype.clone();

        assertEquals(prototype.getContext(), clone.getContext());
    }

}