package com.example.lambdas;

import java.util.function.Consumer;

public class LambdaExpressions {

    public static void main(String[] args) {
        Foo foo = new Foo();
        interface FunctionalInterface {
            void greetSomeone(String name);
        }
        FunctionalInterface func = new FunctionalInterface() {
            @Override
            public void greetSomeone(String name) {
                System.out.println("Hello, " + name + "!");
            }
        };
        foo.bar(func::greetSomeone);
        foo.bar(name -> System.out.println("Hello, " + name + "!"));
    }

}

class Foo {
    public void bar(Consumer<String> consumer) {
        consumer.accept("BAR");
    }
}


