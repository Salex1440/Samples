package com.salex.generating.singleton;

public class Singleton {

    private static Singleton instance = null;
    private static final Object mutex = new Object();

    private Singleton() {
        System.out.println("Created a new instance");
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (mutex) {
                instance = (instance == null) ? new Singleton() : instance;
            }
        }
        System.out.println("Got instance");
        return instance;
    }

}
