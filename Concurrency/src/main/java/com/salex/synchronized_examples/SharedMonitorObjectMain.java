package com.salex.synchronized_examples;

/**
 * Два разных инстанса имеют один монитор, поэтому при вызове блокирующего метода в одном объекте,
 * также блокируется метод другого объекта.
 */
public class SharedMonitorObjectMain {
    public static void main(String[] args) {
        Object monitor = new Object();
        SharedMonitorObject smo1 = new SharedMonitorObject(monitor);
        SharedMonitorObject smo2 = new SharedMonitorObject(monitor);

        Runnable runnable1 = () -> {
            smo1.incCounter();
        };
        Runnable runnable2 = () -> {
            smo2.incCounter();
        };
        Thread t1 = new Thread(runnable1, "Thread 1");
        Thread t2 = new Thread(runnable2, "Thread 2");
        t1.start();
        t2.start();
        System.out.println("Threads started");
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Threads terminated");
    }
}
