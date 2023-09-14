package com.salex.thread_examples;

public class SleepExample {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("Thread " + Thread.currentThread().getName() + " is running");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread " + Thread.currentThread().getName() + " stopped");
        };
        Thread t = new Thread(runnable);
        t.start();
    }
}
