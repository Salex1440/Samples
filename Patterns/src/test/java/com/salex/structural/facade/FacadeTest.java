package com.salex.structural.facade;

import org.junit.jupiter.api.Test;

class FacadeTest {

    @Test
    void operate() {
        Facade facade = new Facade(new Service1(), new Service2());
        facade.operate();
    }
}