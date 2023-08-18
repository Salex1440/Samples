package com.example.streams;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Functions {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        System.out.println("Initial data:");
        for(var i : list) {
            System.out.print(i + " ");
        }
        System.out.println();

        BiFunction<Integer, Integer, Integer> bf = (i, m) -> i * m;
        Function<Integer, Integer> f = i -> i * 2;
        List<Integer> result = list.stream()
                .map(f)
                .collect(Collectors.toList());

        System.out.println("Result:");
        for(var i : result) {
            System.out.print(i + " ");
        }
    }
}
