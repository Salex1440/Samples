package com.salex.deadlock_example.prevention;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockPreventionExample {
    public static void main(String[] args) {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        Runnable runnable1 = new RunnableTryLock1(lock1, lock2);
        Runnable runnable2 = new RunnableTryLock2(lock1, lock2);

        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);
        t1.start();
        t2.start();
    }
}
