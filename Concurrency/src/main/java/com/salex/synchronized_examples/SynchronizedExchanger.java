package com.salex.synchronized_examples;

public class SynchronizedExchanger {

    protected Object object = null;

    public synchronized void setObject(Object o) {
        this.object = o;
    }

    public synchronized void setObject2(Object o) {
        synchronized (this) {
            this.object = o;
        }
    }

    public synchronized Object getObject() {
        return this.object;
    }

    public synchronized Object getObject2() {
        synchronized (this) {
            return this.object;
        }
    }


}
