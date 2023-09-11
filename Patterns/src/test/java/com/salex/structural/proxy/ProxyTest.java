package com.salex.structural.proxy;

import org.junit.jupiter.api.Test;

class ProxyTest {

    @Test
    public void test() {
        Subject proxy = new Proxy();
        proxy.operate();
    }

}