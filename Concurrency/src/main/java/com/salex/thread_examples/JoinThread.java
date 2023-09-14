package com.salex.thread_examples;

import static java.lang.Thread.sleep;

public class JoinThread {

    public static void main(String[] args) {
        String mainThreadName = Thread.currentThread().getName();
        System.out.println(mainThreadName + " started");

        Runnable runnable = () -> {
            System.out.println("Thread " + Thread.currentThread().getName() + " started");
            for (int i = 0; i < 5; i ++) {
                try {
                    sleep(1000);
                    System.out.println("Thread " + Thread.currentThread().getName() + " is running");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Thread " + Thread.currentThread().getName() + " stopped");
        };

        Thread t = new Thread(runnable, "THREAD");
        t.setDaemon(true);
        t.start();

        // При использовании join() главный поток заблокируется и будет ожидать завершения потока THREAD.
        try {
            System.out.println(t.getName() + " joined to the " + mainThreadName);
            t.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(mainThreadName + " terminated");
    }
}
