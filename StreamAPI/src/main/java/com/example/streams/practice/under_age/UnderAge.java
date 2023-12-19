package com.example.streams.practice.under_age;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Get the names of all kids under the age of 18
 */
public class UnderAge {

    public static void main(String[] args) {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        Person anna = new Person("Anna", 5);
        List<Person> collection = Arrays.asList(sara, eva, viktor, anna);
        assertThat(getKidNames(collection))
            .contains("Sara", "Anna")
            .doesNotContain("Viktor", "Eva");
    }

    public static Set<String> getKidNames(List<Person> people) {
        return people.stream()
            .filter(p -> p.getAge() < 18)
            .map(Person::getName)
            .collect(Collectors.toSet());
    }

}
