package org.example;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
@Slf4j
public class App {
    public static void main(String[] args) {
        log.info("Hello World!");
        Map<String, String> map = new HashMap<>();
        map.put("sensitive", "sensitive");
        map.put("public", "public");
        String logMsg = map.entrySet().stream()
            .map(e -> String.format("%s -> %s", e.getKey(), e.getValue()))
            .collect(Collectors.joining(",\n"));

        log.info(logMsg);
    }
}
