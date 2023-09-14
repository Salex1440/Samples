package com.salex.thread_examples;

public class StoppableThread {

    public static class StoppableRunnable implements Runnable {

        private boolean stopFlag = false;

        @Override
        public void run() {
            System.out.println("Thread " + Thread.currentThread().getName() + " is running");
            while (!isStopped()) {
                sleep(1000);
                System.out.println("...");
            }
            System.out.println("Thread " + Thread.currentThread().getName() + " stopped");
        }

        private static void sleep(long millis) {
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        public synchronized void requestStop() {
            this.stopFlag = true;
        }

        public synchronized boolean isStopped() {
            return this.stopFlag;
        }


    }

    public static void main(String[] args) {
        StoppableRunnable runnable = new StoppableRunnable();
        Thread t = new Thread(runnable);
        t.start();
        try {
            Thread.sleep(2100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        runnable.requestStop();
    }
}
