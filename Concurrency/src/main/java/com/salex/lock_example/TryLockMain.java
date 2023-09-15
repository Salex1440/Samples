package com.salex.lock_example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockMain {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Runnable runnable = () -> {
            boolean locked = false;
            try {
                System.out.println("Trying to lock the Lock");
                locked = lock.tryLock();
                System.out.println(Thread.currentThread().getName() + " is locked: " + locked);
            } finally {
                if (locked) {
                    lock.unlock();
                }
            }
        };
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        t1.start();
        t2.start();
        t3.start();
    }
}
