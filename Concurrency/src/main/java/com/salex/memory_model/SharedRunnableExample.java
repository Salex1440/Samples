package com.salex.memory_model;

/**
 * Два потока, запустившие один и тот же инстанс Runnable, будут иметь общие поля.
 * Поэтому они войдут в состояние гонки.
 */
public class SharedRunnableExample {
    public static void main(String[] args) {

        CustomRunnable runnable = new CustomRunnable();
        Thread t1 = new Thread(runnable, "Thread 1");
        Thread t2 = new Thread(runnable, "Thread 2");

        t1.start();
        t2.start();
    }
}
