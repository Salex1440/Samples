package com.salex;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        List<String> strs = List.of("one, thwo", "three", "four", "five");
        List<Object> objs = new ArrayList<>();
//        objs = strs;
        Predicate<String> predLen = w -> w.length() == 3;
        List<String> res = strs.stream()
            .filter(predLen)
            .collect(Collectors.toList());

        System.out.println();

    }
}
