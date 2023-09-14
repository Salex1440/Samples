package com.salex.synchronized_examples;

public class MultiplyMonitorObjects {

    private Object monitor1 = new Object();
    private Object monitor2 = new Object();
    private int cnt1 = 0;
    private int cnt2 = 0;

    public void incCounter1() {
        synchronized (this.monitor1) {
            this.cnt1++;
        }
    }

    public void incCounter2() {
        synchronized (this.monitor2) {
            this.cnt2++;
        }
    }
}
