package com.example.streams.practice.joining;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 *
 Return a comma-separated string of all these people's names, you'll need a special collector for this one
 */
public class Joining {

    public static void main(String[] args) {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        List<Person> collection = Arrays.asList(sara, viktor, eva);
        assertThat(namesToString(collection))
            .isEqualTo("Names: Sara, Viktor, Eva.");
    }

    public static String namesToString(List<Person> people) {
        return people.stream()
            .map(Person::getName)
            .collect(Collectors.joining(", ", "Names: ", "."));
    }

}
