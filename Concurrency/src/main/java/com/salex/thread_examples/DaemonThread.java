package com.salex.thread_examples;

public class DaemonThread {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("Thread " + Thread.currentThread().getName() + " is running");
            String threadName = Thread.currentThread().getName();
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(threadName + " is running...");
            }
        };
        Thread t = new Thread(runnable, "THREAD");
        // Если закомментировать следующую строку, то поток THREAD не позволит JVM завершить выполнение программы.
        // Если же сделать поток фоновым, он не станет препятствовать завершению JVM после выполнения главного потока,
        // и завершится сам. Поэтому, нужно быть крайне аккуратным с фоновыми потоками, т.к. они могут остановиться
        // в неопределенном состоянии и не завершить работу корректно, что может привести к побочным эффектам.
        t.setDaemon(true);
        t.start();
        try {
            Thread.sleep(2100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String mainThreadName = Thread.currentThread().getName();
        System.out.println(mainThreadName + " thread stopped");
    }
}
