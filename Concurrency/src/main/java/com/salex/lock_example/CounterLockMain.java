package com.salex.lock_example;

public class CounterLockMain {
    public static void main(String[] args) {
        CounterLock counterLock = new CounterLock();
        Runnable runnable = () -> {
            for (int i = 0; i < 1_000_000; i++) {
                counterLock.inc();
            }
            System.out.println(Thread.currentThread().getName() + ": " + counterLock.getCounter());
        };
        Thread t1 = new Thread(runnable, "Thread 1");
        Thread t2 = new Thread(runnable, "Thread 2");
        t1.start();
        t2.start();
    }
}
