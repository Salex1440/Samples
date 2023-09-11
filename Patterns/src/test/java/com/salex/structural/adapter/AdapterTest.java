package com.salex.structural.adapter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdapterTest {

    @Test
    public void test() {
        FinalClass target = new FinalClass();
        Adapter adapter = new AdapterImpl(target);

        String result = adapter.doSth("context", 2);

        System.out.println("Returned value: " + result);
    }

}