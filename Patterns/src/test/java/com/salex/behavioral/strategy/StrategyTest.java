package com.salex.behavioral.strategy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StrategyTest {

    @Test
    public void test() {
        Service service = new Service();
        Strategy strategyA = new StrategyA();
        Strategy strategyB = new StrategyB();

        service.doSth(strategyA);
        service.doSth(strategyB);
    }

}