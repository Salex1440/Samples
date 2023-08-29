package com.salex.collections;

import java.util.*;

public class SetExample {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();

        System.out.println();
        addOps(hashSet);
        addOps(linkedHashSet);
        addOps(treeSet);

        System.out.println();
        containsOps(hashSet);
        containsOps(linkedHashSet);
        containsOps(treeSet);

        System.out.println();
        removeOps(hashSet);
        removeOps(linkedHashSet);
        removeOps(treeSet);
    }



    private static void addOps(Set<String> set) {
        long start, end;
        double time;
        int amount = 10_000;
        start = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            set.add("String" + i);
        }
        end = System.nanoTime();
        time = (double) (end - start) / 1_000_000;
        System.out.println(set.getClass() + " ADD ops: " + time + " ms");
    }

    private static void containsOps(Set<String> set) {
        long start, end;
        double time;
        int amount = 10_000;
        start = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            set.contains("String" + i);
        }
        end = System.nanoTime();
        time = (double) (end - start) / 1_000_000;
        System.out.println(set.getClass() + " CONTAINS ops: " + time + " ms");
    }

    private static void removeOps(Set<String> set) {
        long start, end;
        double time;
        int amount = 10_000;
        start = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            set.remove("String" + i);
        }
        end = System.nanoTime();
        time = (double) (end - start) / 1_000_000;
        System.out.println(set.getClass() + " REMOVE ops: " + time + " ms");
    }
}
