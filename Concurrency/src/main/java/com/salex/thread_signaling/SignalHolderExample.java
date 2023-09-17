package com.salex.thread_signaling;

public class SignalHolderExample {
    public static void main(String[] args) {
        SignalHolder signalHolder = new SignalHolder();

        Runnable runnable1 = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " started.");
                System.out.println(Thread.currentThread().getName() + " working...");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " waiting a signal...");
                signalHolder.doWait();
                System.out.println(Thread.currentThread().getName() + " received the signal.");
                System.out.println(Thread.currentThread().getName() + " terminated.");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable runnable2 = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " started.");
                System.out.println(Thread.currentThread().getName() + " working...");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " emitting the signal.");
                signalHolder.doNotify();
                System.out.println(Thread.currentThread().getName() + " working...");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " terminated.");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Thread waitingThread = new Thread(runnable1);
        Thread notifyingThread = new Thread(runnable2);
        notifyingThread.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        waitingThread.start();
    }
}
