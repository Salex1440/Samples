package com.salex.immutable_objects_without_synchronization;

import java.math.BigInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

/**
 * В данном примере сравниваются два подхода синхронизации:
 * 1) Через ключевое слово synchronised
 * 2) С использованием неизменяемых объектов
 *
 * Оба способа являются потокобезопасными.
 * Что касаемо производительности: при малом количестве потоков (numberThreads < 10_000) второй способ чуть быстрее первого.
 * Но с увеличением количества потоков, способ с классической синхронизацией работает быстрее.
 *
 * П.С.: Можно поэксперементировать еще с количеством потоков в пуле. Сейчас их 10.
 */
public class Main {
    public static void main(String[] args) {
        int numberThreads = 10_000;
        double duration1 = synchronisedFactorisation(numberThreads);
        double duration2 = immutableObjectWithoutSyncronization(numberThreads);

        System.out.println("Execution time: " + duration1 + " ms");
        System.out.println("Execution time: " + duration2 + " ms");
    }

    private static double synchronisedFactorisation(int numberThreads) {
        SynchronizedFactoriser factoriser = new SynchronizedFactoriser();
        Runnable runnable = () -> {
            BigInteger bigInteger = BigInteger.valueOf(ThreadLocalRandom.current().nextLong(100));
            BigInteger[] bigIntegers = factoriser.service(bigInteger);
//            StringBuilder sb = new StringBuilder();
//            sb.append(bigInteger).append(" : ");
//            for (BigInteger i : bigIntegers) {
//                sb.append(i).append(" ");
//            }
//            System.out.println(sb);
        };
        long start = System.nanoTime();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < numberThreads; i++) {
            executorService.submit(runnable);
        }
        executorService.shutdown();
        long end = System.nanoTime();
        double duration = (double)(end - start) / 1000000;
        return duration;
    }

    private static double immutableObjectWithoutSyncronization(int numberThreads) {
        VolatileCacheFactoriser factoriser = new VolatileCacheFactoriser();
        Runnable runnable = () -> {
            BigInteger bigInteger = BigInteger.valueOf(ThreadLocalRandom.current().nextLong(100));
            BigInteger[] bigIntegers = factoriser.service(bigInteger);
//            StringBuilder sb = new StringBuilder();
//            sb.append(bigInteger).append(" : ");
//            for (BigInteger i : bigIntegers) {
//                sb.append(i).append(" ");
//            }
//            System.out.println(sb);
        };
        long start = System.nanoTime();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < numberThreads; i++) {
            executorService.submit(runnable);
        }
        executorService.shutdown();
        long end = System.nanoTime();
        double duration = (double)(end - start) / 1000000;
        return duration;
    }
}
