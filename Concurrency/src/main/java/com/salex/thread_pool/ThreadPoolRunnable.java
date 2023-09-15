package com.salex.thread_pool;

import java.util.concurrent.BlockingQueue;

public class ThreadPoolRunnable implements Runnable {

    private Thread thread;
    private final BlockingQueue taskQueue;
    private boolean isStopped = false;
    public ThreadPoolRunnable(BlockingQueue<Runnable> taskQueue) {
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        this.thread = Thread.currentThread();
        while (!isStopped()) {
            try {
                Runnable runnable = (Runnable) taskQueue.take();
                runnable.run();
            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void stop() {
        this.isStopped = true;
        this.thread.interrupt();
    }

    public synchronized boolean isStopped() {
        return this.isStopped;
    }
}
