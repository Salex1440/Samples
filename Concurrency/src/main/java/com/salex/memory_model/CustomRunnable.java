package com.salex.memory_model;

public class CustomRunnable implements Runnable {
    // Поля класса подвержены состоянию гонки, если данный класс используется несколькими потоками.
    private int count = 0;
    @Override
    public void run() {
        // Локальные переменные не подвержены состоянию гонки,
        // т.к. они создаются в локальном стэке потока.
        int localCount = 0;
        for (int i = 0; i < 1_000_000; i++) {
            this.count++;
            localCount++;
        }
        System.out.println(Thread.currentThread().getName() + ":" +
                " shared count = " + this.count +
                " local count = " + localCount);
    }
}
