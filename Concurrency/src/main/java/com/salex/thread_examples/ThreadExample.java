package com.salex.thread_examples;

public class ThreadExample {

    public static class CustomThread extends Thread {

        @Override
        public void run() {
            System.out.println("Thread " + Thread.currentThread().getName() + " is running");
            System.out.println("Thread " + Thread.currentThread().getName() + " stopped");
        }
    }

    public static void main(String[] args) {
        Thread t = new CustomThread();
        t.start();
    }

}
