package com.salex.thread_examples;

public class RunnableExample {

    public static class CustomRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("Thread " + Thread.currentThread().getName() + " is running");
            System.out.println("Thread " + Thread.currentThread().getName() + " stopped");
        }
    }
    public static void main(String[] args) {
        Thread t = new Thread(new CustomRunnable(), "THREAD");
        t.start();
    }
}
