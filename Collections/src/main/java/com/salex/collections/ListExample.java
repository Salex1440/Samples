package com.salex.collections;

import java.util.*;

public class ListExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> vector = new Vector<>();
        List<String> stack = new Stack<>();
        List<String> linkedList = new LinkedList<>();

        System.out.println();
        addOps(list);
        addOps(vector);
        addOps(stack);
        addOps(linkedList);

        System.out.println();
        getOps(list);
        getOps(vector);
        getOps(stack);
        getOps(linkedList);

        System.out.println();
        removeOps(list);
        removeOps(vector);
        removeOps(stack);
        removeOps(linkedList);

    }

    private static void addOps(List<String> list) {
        long start, end;
        double time;
        int amount = 10_000;
        start = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            list.add("String");
        }
        end = System.nanoTime();
        time = (double) (end - start) / 1_000_000;
        System.out.println(list.getClass() + " ADD ops: " + time + " ms");
    }

    private static void getOps(List<String> list) {
        long start, end;
        double time;
        int amount = 10_000;
        start = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            list.get(i);
        }
        end = System.nanoTime();
        time = (double) (end - start) / 1_000_000;
        System.out.println(list.getClass() + " GET ops: " + time + " ms");
    }

    private static void removeOps(List<String> list) {
        long start, end;
        double time;
        int amount = 10_000;
        start = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            int idx = 0;
//            int idx = (list.size()/2);
//            int idx = (list.size() - 1);
            list.remove(idx);
        }
        end = System.nanoTime();
        time = (double) (end - start) / 1_000_000;
        System.out.println(list.getClass() + " REMOVE ops: " + time + " ms");
    }


}
