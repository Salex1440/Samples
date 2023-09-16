package com.salex.deadlock_example;

import java.util.concurrent.locks.Lock;

public class RunnableImpl2 implements Runnable {
    private final Lock lock1;
    private final Lock lock2;

    public RunnableImpl2(Lock lock1, Lock lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        try {
            notify("started");
            notify("lock lock2");
            lock2.lock();

            notify("working...");
            Thread.sleep(1000);

            notify("lock lock1");
            lock1.lock();

            notify("working...");
            Thread.sleep(1000);

            System.out.println("unlock lock1");
            lock1.unlock();
            System.out.println("unlock lock2");
            lock2.unlock();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void notify(String msg) {
        System.out.println(Thread.currentThread().getName() + ": " + msg);
    }
}
