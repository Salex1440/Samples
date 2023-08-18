package com.example.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamApi {
    public static void main(String[] args) {
        List<String> list = List.of("Alice", "Bob", "Harry", "Bella", "Billy", "Willy", "WILly");
        Map<String, Integer> map = list.stream()
                .filter(str -> str.length() > 4)
                .filter(str -> str.contains("l"))
                .map(String::toLowerCase)
                .collect(Collectors.toMap(
                        str -> str,
                        String::length,
                        (i1, i2) -> i1
                ));
        for (var e : map.keySet()) {
            System.out.println(e + " : " + map.get(e));
        }
    }
}
