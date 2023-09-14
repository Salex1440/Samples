package com.salex.thread_examples;

public class LambdaExample {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("Thread " + Thread.currentThread().getName() + " is running");
            System.out.println("Thread " + Thread.currentThread().getName() + " stopped");
        };
        Thread t = new Thread(runnable, "THREAD");
        t.start();
    }

}
