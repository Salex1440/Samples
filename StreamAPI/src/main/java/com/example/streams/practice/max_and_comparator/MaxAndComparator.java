package com.example.streams.practice.max_and_comparator;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Get the oldest person from the collection
 */
public class MaxAndComparator {

    public static void main(String[] args) {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        List<Person> collection = Arrays.asList(sara, eva, viktor);
        assertThat(MaxAndComparator.getOldestPerson(collection)).isEqualToComparingFieldByField(eva);
    }

    public static Person getOldestPerson(List<Person> people) {
        return people.stream()
            .max(Comparator.comparingInt(Person::getAge))
            .orElse(new Person("", 0));
    }
}
