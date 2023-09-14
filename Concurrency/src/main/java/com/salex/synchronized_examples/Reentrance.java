package com.salex.synchronized_examples;

/**
 * В данном примере метод синхронный incrementAndGet() вызывает синхронный метод increment().
 * Но т.к. данные методы используют один и тот же монитор, не производится блокировка потока,
 * т.е. происходит возвращение того же монитора.
 */
public class Reentrance {
    private int cnt = 0;

    public synchronized void increment() {
        this.cnt++;
    }

    public synchronized int incrementAndGet() {
        increment();
        return this.cnt;
    }
}
