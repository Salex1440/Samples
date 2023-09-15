package com.salex.thread_pool;

public class ThreadPoolMain {
    public static void main(String[] args) {
        CustomThreadPool threadPool = new CustomThreadPool(3, 10);
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName() + " started...");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " terminated.");
        };
        for (int i = 0; i < 50; i++) {
            threadPool.execute(runnable);
        }
        threadPool.waitUntilAllTasksFinished();
        threadPool.stop();
    }
}
