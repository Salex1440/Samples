package com.example.lambdas;

public class AnonymousClasses {

    public static void main(String[] args) {
        Greeting anonymousGreeting = new Greeting() {
            @Override
            public void helloSomeone() {
                System.out.println("Hello, anonymous!");
            }

            @Override
            public void helloSomeone(String name) {
                System.out.println("Hello, " + name + "!");
            }
        };

        GreetingImpl anonymousGreetingImpl = new GreetingImpl() {
            private String name = "World";

            @Override
            public void helloSomeone() {
                System.out.println("Hello, " + name + "!");
                super.helloSomeone();
            }
        };

        anonymousGreeting.helloSomeone();
        anonymousGreetingImpl.helloSomeone();
    }
}

