package com.salex.creational.builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuilderTest {

    @Test
    public void test() {
        String name = "Alex";
        int age = 27;
        Sex sex = Sex.MALE;
        Person person = Person.builder()
            .name(name)
            .age(age)
            .sex(sex)
            .build();

        assertEquals(name, person.getName());
        assertEquals(age, person.getAge());
        assertEquals(sex, person.getSex());
    }

}