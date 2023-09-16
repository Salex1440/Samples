package com.salex.deadlock_example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockMain {
    public static void main(String[] args) {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();

        Runnable runnable1 = new RunnableImpl1(lock1, lock2);
        Runnable runnable2 = new RunnableImpl2(lock1, lock2);

        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);
        t1.start();
        t2.start();
    }
}
