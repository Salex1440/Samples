package com.salex.executor_service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceExamples {

    public static void main(String[] args) {
        fixedThreadPoolExample();
        threadPoolExample();
        cancelTaskExample();
        invokeAnyExample();
        invokeAllExample();
        shutdownNowExample();
    }

    private static void fixedThreadPoolExample() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Runnable runnable = () -> {
            String s = Thread.currentThread().getName() + ": Runnable execution";
            System.out.println(s);
        };
        executorService.execute(runnable);
        executorService.shutdown();
    }

    private static void threadPoolExample() {
        int corePoolSize = 2;
        int maximumPoolSize = 4;
        int keepAliveTime = 1000;
        BlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>();
        ExecutorService executorService = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.MILLISECONDS, blockingQueue);

        Callable<String> callable = () -> {
            String s = Thread.currentThread().getName() + ": Callable execution";
            System.out.println(s);
            return s;
        };

        Future<String> future = executorService.submit(callable);
        System.out.println("Task is done: " + future.isDone());
        try {
            String s = future.get();
            System.out.println("Returned value: " + s);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Task is done: " + future.isDone());

        executorService.shutdown();
    }

    private static void cancelTaskExample() {

        int corePoolSize = 2;
        int maximumPoolSize = 4;
        int keepAliveTime = 1000;
        BlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>();
        ExecutorService executorService = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.MILLISECONDS, blockingQueue);

        Callable<String> callable = () -> {
            String s = Thread.currentThread().getName() + ": Callable execution";
            Thread.sleep(100);
            System.out.println(s);
            return s;
        };

        Future<String> future = executorService.submit(callable);
        System.out.println("Task is done: " + future.isDone());
        future.cancel(true);
        try {
            String s = future.get();
            System.out.println("Returned value: " + s);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } catch (CancellationException e) {
            System.out.println("The task was cancelled!");
            System.out.println("Is cancelled: " + future.isCancelled());
        }
        System.out.println("Task is done: " + future.isDone());

        executorService.shutdown();
    }

    private static void invokeAnyExample() {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        List<Callable<String>> callables = new ArrayList<>();
        callables.add(newCallable("Callable 1"));
        callables.add(newCallable("Callable 2"));
        callables.add(newCallable("Callable 3"));

        try {
            String result = executorService.invokeAny(callables);
            System.out.println(result);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown();
    }

    private static void invokeAllExample() {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        List<Callable<String>> callables = new ArrayList<>();
        callables.add(newCallable("Callable 1"));
        callables.add(newCallable("Callable 2"));
        callables.add(newCallable("Callable 3"));

        try {
            List<Future<String>> futures = executorService.invokeAll(callables);
            for (Future<String> future : futures) {
                System.out.println(future.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown();
    }

    private static Callable<String> newCallable(String msg) {
        return  () -> {
            String s = Thread.currentThread().getName() + ": " + msg;
            return s;
        };
    }

    private static void shutdownNowExample() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Runnable runnable = () -> {
            System.out.println("Runnable started");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Runnable terminated");
        };

        executorService.execute(runnable);
        List<Runnable> runnables = executorService.shutdownNow();

        boolean isTerminated = false;
        try {
            isTerminated = executorService.awaitTermination(1000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("All runnables are terminated: " + isTerminated);

    }
}
