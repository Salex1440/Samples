package com.salex.synchronized_examples;

public class MixedSynchronizationMain {
    public static void main(String[] args) {
        MixedSynchronization exchanger = new MixedSynchronization();
        Runnable runnable1 = () -> {
            for (int i = 0; i < 1_000_000; i++) {
                MixedSynchronization.setStaticObj(Integer.valueOf(i));
            }
            System.out.println(Thread.currentThread().getName() + ": " + MixedSynchronization.getStaticObj());
        };
        Runnable runnable2 = () -> {
            for (int i = 0; i < 1_000_000; i++) {
                exchanger.setInstanceObj(Integer.valueOf(i));
            }
            System.out.println(Thread.currentThread().getName() + ": " + exchanger.getInstanceObj());
        };
        Thread t1 = new Thread(runnable1, "Static thread");
        Thread t2 = new Thread(runnable2, "Instance thread");
        t1.start();
        t2.start();
    }
}
