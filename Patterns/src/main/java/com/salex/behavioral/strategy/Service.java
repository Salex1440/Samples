package com.salex.behavioral.strategy;

public class Service {

    public void doSth(Strategy strategy) {
        strategy.execute();
    }
}
