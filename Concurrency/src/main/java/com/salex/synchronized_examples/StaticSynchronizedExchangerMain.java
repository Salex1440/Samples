package com.salex.synchronized_examples;

public class StaticSynchronizedExchangerMain {

    public static void main(String[] args) {
        StaticSynchronizedExchanger exchanger = new StaticSynchronizedExchanger();
        Runnable runnable1 = () -> {
            for (int i = 0; i < 1_000_000; i++) {
                exchanger.setObject(Integer.valueOf(i));
            }
            System.out.println(Thread.currentThread().getName() + ": " + exchanger.getObject());
        };
        Runnable runnable2 = () -> {
            for (int i = 0; i < 1_000_000; i++) {
                exchanger.setObject2(Integer.valueOf(i));
            }
            System.out.println(Thread.currentThread().getName() + ": " + exchanger.getObject2());
        };
        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);
        t1.start();
        t2.start();
    }
}
