package com.salex.thread_signaling;

public class SignalCarrier {

    public synchronized void doWait() throws InterruptedException {
        this.wait();
    }

    public synchronized void doNotify() {
        this.notify();
    }

    public synchronized void doNotifyAll() {
        this.notifyAll();
    }

}
