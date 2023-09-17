package com.salex.thread_signaling;

public class SignalHolder {

    private boolean signalRaised = false;
    private boolean isThreadWaiting = false;

    public synchronized void doWait() throws InterruptedException {
        if (signalRaised) {
            System.out.println(Thread.currentThread().getName() + " signal was already raised");
            signalRaised = false;
            return;
        }
        isThreadWaiting = true;
        this.wait();
        isThreadWaiting = false;
    }

    public synchronized void doNotify() {
        if (!isThreadWaiting) {
            signalRaised = true;
        }
        this.notify();
    }

    public synchronized void doNotifyAll() {
        if (!isThreadWaiting) {
            signalRaised = true;
        }
        this.notifyAll();
    }



}
