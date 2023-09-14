package com.salex.synchronized_examples;

public class StaticSynchronizedExchanger {
    private static Object object = null;

    public static synchronized void setObject(Object o) {
        object = o;
    }

    public static synchronized void setObject2(Object o) {
        synchronized (SynchronizedExchanger.class) {
            object = o;
        }
    }

    public static synchronized Object getObject() {
        return object;
    }

    public static synchronized Object getObject2() {
        synchronized (SynchronizedExchanger.class) {
            return object;
        }
    }
}
