package com.salex.deadlock_example.prevention;

import java.util.concurrent.locks.Lock;

public class RunnableTryLock1 implements Runnable {

    private final Lock lock1;
    private final Lock lock2;

    public RunnableTryLock1(Lock lock1, Lock lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        try {
            notify("started");
            int failureCount = 0;
            while (!tryLockBothLocks()) {
                failureCount++;
                notify("falied to lock both locks. Waithing a bit before retrying " +
                    "[" + failureCount + " tries]");
                Thread.sleep((long) (100 + 1000L * Math.random()));
            }
            if (failureCount > 0) {
                notify("succeed in locking both locks after " + failureCount + " tries");
            }
            lock2.unlock();
            lock1.unlock();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean tryLockBothLocks() {
        if (!lock1.tryLock()) {
            return false;
        }
        try {
            notify("working...");
            Thread.sleep(1000L);
        } catch (InterruptedException e) {

        }
        if (!lock2.tryLock()) {
            lock1.unlock();
            return false;
        }

        try {
            notify("working...");
            Thread.sleep(1000L);
        } catch (InterruptedException e) {

        }
        return true;
    }

    private void notify(String msg) {
        System.out.println(Thread.currentThread().getName() + ": " + msg);
    }

}
