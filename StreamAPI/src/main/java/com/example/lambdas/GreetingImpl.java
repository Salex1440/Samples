package com.example.lambdas;

public class GreetingImpl implements Greeting {
    @Override
    public void helloSomeone() {
        System.out.println("Hello Implementation!");
    }

    @Override
    public void helloSomeone(String name) {
        System.out.println("Hello, " + name + "!");
    }
}
