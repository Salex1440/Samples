package com.example.streams.practice.group_by;


import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Partition these people into adults and kids, you'll need a special collector for this one
 */
public class GroupBy {

    public static void main(String[] args) {
        Person sara = new Person("Sara", 4, "Norwegian");
        Person viktor = new Person("Viktor", 40, "Serbian");
        Person eva = new Person("Eva", 42, "Norwegian");
        List<Person> collection = Arrays.asList(sara, eva, viktor);
        Map<Boolean, List<Person>> result = GroupByAge(collection);
        assertThat(result.get(true)).hasSameElementsAs(Arrays.asList(viktor, eva));
        assertThat(result.get(false)).hasSameElementsAs(Collections.singletonList(sara));
        Map<String, List<Person>> result2 = groupByNationality(collection);
        assertThat(result2.get("Norwegian")).hasSameElementsAs(Arrays.asList(sara, eva));
        assertThat(result2.get("Serbian")).hasSameElementsAs(Arrays.asList(viktor));
    }

    public static Map<Boolean, List<Person>> GroupByAge(List<Person> people) {
        return people.stream()
            .collect(Collectors.groupingBy(person -> person.getAge() >= 18));
    }

    public static Map<String, List<Person>> groupByNationality(List<Person> people) {
        return people.stream()
            .collect(Collectors.groupingBy(p -> p.getNationality()));
    }
}
