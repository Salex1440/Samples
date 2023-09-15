package com.salex.thread_pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class CustomThreadPool {

    private BlockingQueue<Runnable> taskQueue = null;
    private List<ThreadPoolRunnable> runnables = new ArrayList<>();
    private boolean isStopped = false;

    public CustomThreadPool(int numOfThreads, int maxNumOfTasks) {
//        taskQueue = new ArrayBlockingQueue<>(maxNumOfTasks);
        taskQueue = new LinkedBlockingQueue<>(maxNumOfTasks);

        for (int i = 0; i < numOfThreads; i++) {
            ThreadPoolRunnable poolThreadRunnable = new ThreadPoolRunnable(taskQueue);
            runnables.add(poolThreadRunnable);
        }
        for (ThreadPoolRunnable runnable : runnables) {
            new Thread(runnable).start();
        }
    }

    public synchronized void execute(Runnable task) throws IllegalStateException {
        if (this.isStopped) {
            throw new IllegalStateException("ThreadPool is stopped");
        }
        this.taskQueue.offer(task);
    }

    public synchronized void stop() {
        this.isStopped = true;
        for (ThreadPoolRunnable runnable : runnables) {
            runnable.stop();
        }
    }

    public synchronized void waitUntilAllTasksFinished() {
        while (this.taskQueue.size() > 0 ) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
