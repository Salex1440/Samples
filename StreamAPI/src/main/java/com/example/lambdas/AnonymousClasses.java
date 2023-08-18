package com.example.anonymous;

public class AnonymousClasses {

    public static void main(String[] args) {
        Greeting anonymousGreeting = new Greeting() {
            @Override
            public void hello() {
                System.out.println("Hello, anonymous!");
            }
        };

        GreetingImpl anonymousGreetingImpl = new GreetingImpl() {
            private String name = "World";

            @Override
            public void hello() {
                System.out.println("Hello, " + name + "!");
                super.hello();
            }
        };

        anonymousGreeting.hello();
        anonymousGreetingImpl.hello();
    }
}

