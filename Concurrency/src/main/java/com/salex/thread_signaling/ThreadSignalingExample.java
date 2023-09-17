package com.salex.thread_signaling;

public class ThreadSignalingExample {
    public static void main(String[] args) {
        Object monitor = new Object();

        Runnable runnable1 = () -> {
            synchronized (monitor) {
                try {
                    System.out.println(Thread.currentThread().getName() + " started.");
                    System.out.println(Thread.currentThread().getName() + " working...");
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " waiting a signal...");
                    monitor.wait();
                    System.out.println(Thread.currentThread().getName() + " received the signal.");
                    System.out.println(Thread.currentThread().getName() + " terminated.");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable runnable2 = () -> {
            synchronized (monitor) {
                try {
                    System.out.println(Thread.currentThread().getName() + " started.");
                    System.out.println(Thread.currentThread().getName() + " working...");
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " emitting the signal.");
                    monitor.notify();
                    System.out.println(Thread.currentThread().getName() + " working...");
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " terminated.");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Thread waitingThread = new Thread(runnable1);
        Thread notifyingThread = new Thread(runnable2);
        waitingThread.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        notifyingThread.start();
    }
}
