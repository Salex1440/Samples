package com.example.streams.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Flatten this multidimensional collection
 */
public class FlatMap {

    public static void main(String[] args) {
        List<List<String>> collection = Arrays.asList(Arrays.asList("Viktor", "Farcic"), Arrays.asList("John", "Doe", "Third"));
        List<String> expected = Arrays.asList("Viktor", "Farcic", "John", "Doe", "Third");
        assertThat(FlatMap.transform(collection)).hasSameElementsAs(expected);
    }

    public static List<String> transform(List<List<String>> collection) {
        return collection.stream()
            .flatMap(List::stream)
            .collect(Collectors.toList());
    }
}
