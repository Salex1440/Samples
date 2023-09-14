package com.salex.synchronized_examples;

public class MixedSynchronization {
    private static Object object = null;

    public static synchronized Object getStaticObj() {
        return object;
    }

    public static synchronized void setStaticObj(Object o) {
        object = o;
    }

    public synchronized Object getInstanceObj() {
        return object;
    }

    public void setInstanceObj(Object o) {
        synchronized (this) {
            object = o;
        }
    }
}
