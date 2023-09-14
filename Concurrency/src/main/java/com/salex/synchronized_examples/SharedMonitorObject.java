package com.salex.synchronized_examples;

public class SharedMonitorObject {
    private final Object monitor;
    private int counter = 0;

    public SharedMonitorObject(Object monitor) {
        this.monitor = monitor;
    }

    public void incCounter() {
        synchronized (this.monitor) {
            System.out.println(Thread.currentThread().getName() + " incrementing...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.counter++;
        }
    }

}
