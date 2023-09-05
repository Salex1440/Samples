package com.salex.collections;

import java.util.*;

public class QueueExample {
    public static void main(String[] args) {
        Queue<String> linkedList = new LinkedList<>();
        Queue<String> priorityQueue = new PriorityQueue<>();
        Queue<String> arrayDeque = new ArrayDeque<>();

        System.out.println();
        addOps(linkedList);
        addOps(priorityQueue);
        addOps(arrayDeque);

        System.out.println();
        peekOps(linkedList);
        peekOps(priorityQueue);
        peekOps(arrayDeque);

        System.out.println();
        removeOps(linkedList);
        removeOps(priorityQueue);
        removeOps(arrayDeque);

    }

    private static void addOps(Queue<String> queue) {
        long start, end;
        double time;
        int amount = 10_000;
        start = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            queue.add("String");
        }
        end = System.nanoTime();
        time = (double) (end - start) / 1_000_000;
        System.out.println(queue.getClass() + " ADD ops: " + time + " ms");
    }

    private static void peekOps(Queue<String> queue) {
        long start, end;
        double time;
        int amount = 10_000;
        start = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            queue.peek();
        }
        end = System.nanoTime();
        time = (double) (end - start) / 1_000_000;
        System.out.println(queue.getClass() + " PEEK ops: " + time + " ms");
    }

    private static void removeOps(Queue<String> list) {
        long start, end;
        double time;
        int amount = 10_000;
        start = System.nanoTime();
        for (int i = 0; i < amount; i++) {
//            int idx = 0;
//            int idx = (list.size()/2);
//            int idx = (list.size() - 1);
            list.poll();
        }
        end = System.nanoTime();
        time = (double) (end - start) / 1_000_000;
        System.out.println(list.getClass() + " REMOVE ops: " + time + " ms");
    }

}
