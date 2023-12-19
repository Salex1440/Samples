package com.example.streams.practice;

import java.util.Arrays;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;

/**
 * Sum all elements of a collection, try to use the reduce operator with identity parameter instead of an IntStream
 */
public class SumAndReduce {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        assertThat(SumAndReduce.calculate(numbers)).isEqualTo(1 + 2 + 3 + 4 + 5);
    }


    public static int calculate(List<Integer> numbers) {
        return numbers.stream()
            .reduce(0, (i1, i2) -> i1 + i2);
    }

}
