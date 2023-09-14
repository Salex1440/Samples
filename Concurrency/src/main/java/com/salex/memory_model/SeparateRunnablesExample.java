package com.salex.memory_model;

/**
 * Два разных инстанса, реализующих интерфейс Runnable, не будут иметь общих полей.
 * Поэтому потоки, их выполняющие, не получат состояния гонки.
 */
public class SeparateRunnablesExample {
    public static void main(String[] args) {
        CustomRunnable runnable1 = new CustomRunnable();
        CustomRunnable runnable2 = new CustomRunnable();
        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);

        t1.start();
        t2.start();

    }
}
