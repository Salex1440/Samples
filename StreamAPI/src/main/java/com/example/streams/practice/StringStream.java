package com.example.streams.practice;

import java.util.Map;
import java.util.stream.Collectors;

public class StringStream {
    public static void main(String[] args) {
        String str = "sdfaaasff";
        Map<Character, Long> map = str.chars()
            .mapToObj(ch -> (char) ch)
            .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));
        String s = map.entrySet().stream()
            .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
            .map(e -> "\"" + e.getKey() + "\":" + e.getValue())
            .collect(Collectors.joining(", "));
        System.out.println(s);
    }
}
