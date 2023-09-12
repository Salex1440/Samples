package com.salex.behavioral.state;

import org.junit.jupiter.api.Test;


class StateTest {

    @Test
    public void test() {
        Lamp lamp = new Lamp();
        lamp.toggle();
        lamp.toggle();
        lamp.toggle();
        lamp.toggle();
    }

}