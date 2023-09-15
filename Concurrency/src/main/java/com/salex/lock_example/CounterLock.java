package com.salex.lock_example;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterLock {

    private int counter = 0;
    private Lock lock = new ReentrantLock();

    public void inc() {
        try {
            lock.lock();
            counter++;
        } finally {
            lock.unlock();
        }
    }

    public int getCounter() {
        try {
            lock.lock();
            return this.counter;
        } finally {
            lock.unlock();
        }
    }
}
