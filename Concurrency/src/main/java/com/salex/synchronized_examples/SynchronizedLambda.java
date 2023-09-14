package com.salex.synchronized_examples;

import java.util.function.Consumer;

public class SynchronizedLambda {
    private static Object object = null;
    public static synchronized void setObject(Object o) {
        object = o;
    }

    public static void consumeObj(Consumer consumer) {
        consumer.accept(object);
    }

    public static void main(String[] args) {
        consumeObj((obj) -> {
            synchronized (SynchronizedLambda.class) {
                System.out.println(obj);
            }
        });
    }
}
