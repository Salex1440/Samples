package com.salex.thread_signaling;

public class SignalCounter {

    private int signals = 0;
    private int threadWaiting = 0;

    public synchronized void doWait() throws InterruptedException {
        if (signals > 0) {
            System.out.println(Thread.currentThread().getName() + " " + signals + " signal(s) was(were) already raised");
            signals--;
            return;
        }
        threadWaiting++;
        this.wait();
        threadWaiting--;
    }

    public synchronized void doNotify() {
        if (threadWaiting == 0) {
            signals++;
        }
        this.notify();
    }

    public synchronized void doNotifyAll() {
        if (threadWaiting == 0) {
            signals++;
        }
        this.notifyAll();
    }
}
