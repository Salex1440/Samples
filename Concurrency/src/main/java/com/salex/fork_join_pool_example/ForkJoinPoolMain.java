package com.salex.fork_join_pool_example;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolMain {
    public static void main(String[] args) {
        int capacity = 10_000_000;
        int[] array = getArray(capacity);
        int[] array2 = Arrays.copyOf(array, capacity);
        long start, end;
        double time;
        System.out.println("Arrays equals: " + arraysEquals(array, array2));

        start = System.nanoTime();
        Arrays.sort(array);
        end = System.nanoTime();
        time = end - start;
        System.out.println("Time of Arrays.sort(): " + time / 1_000_000 + " ms");
        System.out.println("Arrays equals: " + arraysEquals(array, array2));

        start = System.nanoTime();
        SortingTask sortingTask = new SortingTask(array2);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(sortingTask);
        end = System.nanoTime();
        time = end - start;
        System.out.println("Time of ForkJoin sort: " + time / 1_000_000 + " ms");
        System.out.println("Arrays equals: " + arraysEquals(array, array2));
    }

    private static int[] getArray(int capacity) {
        Random rand = new Random();
        int[] array = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            array[i] = rand.nextInt();
        }
        return array;
    }

    private static boolean arraysEquals(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}
