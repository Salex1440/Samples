package com.salex.maps;

import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        Map<String, String> hashtable = new Hashtable<>();
        Map<String, String> hashMap = new HashMap<>();
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        Map<String, String> treeMap = new TreeMap<>();
        Map<String, String> weakHashMap = new WeakHashMap<>();

        System.out.println();
        putOps(hashtable);
        putOps(hashMap);
        putOps(linkedHashMap);
        putOps(treeMap);
        putOps(weakHashMap);

        System.out.println();
        containsOps(hashtable);
        containsOps(hashMap);
        containsOps(linkedHashMap);
        containsOps(treeMap);
        containsOps(weakHashMap);

        System.out.println();
        removeOps(hashtable);
        removeOps(hashMap);
        removeOps(linkedHashMap);
        removeOps(treeMap);
        removeOps(weakHashMap);
    }

    private static void putOps(Map<String, String> map) {
        long start, end;
        double time;
        int amount = 10_000;
        start = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            map.put("String" + i, "String");
        }
        end = System.nanoTime();
        time = (double) (end - start) / 1_000_000;
        System.out.println(map.getClass() + " PUT ops: " + time + " ms");
    }

    private static void containsOps(Map<String,String> map) {
        long start, end;
        double time;
        int amount = 10_000;
        start = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            map.containsKey("String" + i);
        }
        end = System.nanoTime();
        time = (double) (end - start) / 1_000_000;
        System.out.println(map.getClass() + " CONTAINS ops: " + time + " ms");
    }

    private static void removeOps(Map<String, String> map) {
        long start, end;
        double time;
        int amount = 10_000;
        start = System.nanoTime();
        for (int i = 0; i < amount; i++) {
            map.remove("String" + i);
        }
        end = System.nanoTime();
        time = (double) (end - start) / 1_000_000;
        System.out.println(map.getClass() + " REMOVE ops: " + time + " ms");
    }

}
