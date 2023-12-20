package com.example.streams.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Sort entire list in natural and reverse order
 */
public class Sorted {

    public static void main(String[] args) {
        List<String> collection = Arrays.asList("Viktor", "Farcic", "John", "Doe", "Third");
        List<String> natural = Arrays.asList("Doe", "Farcic", "John", "Third", "Viktor");
        List<String> reversed = Arrays.asList("Viktor", "Third", "John", "Farcic", "Doe");

        assertThat(Sorted.naturalOrder(collection)).hasSameElementsAs(natural);
        assertThat(Sorted.reverseOrder(collection)).hasSameElementsAs(reversed);
    }

    public static List<String> naturalOrder(List<String> collection) {
        return collection.stream()
            .sorted(Comparator.naturalOrder())
            .collect(Collectors.toList());
    }

    public static List<String> reverseOrder(List<String> collection) {
        return collection.stream()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());
    }

}
