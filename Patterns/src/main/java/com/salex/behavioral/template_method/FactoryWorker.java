package com.salex.behavioral.template_method;

public class FactoryWorker extends Person {
    @Override
    protected void wakeUp() {
        System.out.println("Wake up");
    }

    @Override
    protected void breakfast() {
        System.out.println("breakfast");
    }

    @Override
    protected void lunch() {
        System.out.println("Lunch");
    }

    @Override
    protected void dinner() {
        System.out.println("dinner");
    }

    @Override
    protected void work() {
        System.out.println("Work in a factory");
    }

    @Override
    protected void sleep() {
        System.out.println("Sleep");
    }
}
