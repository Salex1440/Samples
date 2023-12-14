package com.salex.creational.singleton;

/**
 * Singleton (Одиночка) - порождающий шаблон проектирования.
 * Гарантирует, что класс имеет только один экземпляр и предоставляет
 * к нему глобальную точку доступа.
 */
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
