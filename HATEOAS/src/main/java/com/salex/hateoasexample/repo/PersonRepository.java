package com.salex.hateoasexample.repo;

import com.salex.hateoasexample.model.Person;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PersonRepository {

    @Getter
    private final Map<String, Person> persons = new HashMap<>();

    public Person createPerson(Person person) {
        if (persons.containsKey(person.getName())) {
            throw new RuntimeException("Person already exists!");
        }
        return persons.put(person.getName(), person);
    }

    public Person getPersonByName(String name) {
        return persons.get(name);
    }

    public Person updatePersonByName(String name, Integer age) {
        if (!persons.containsKey(name)) {
            throw new RuntimeException("Person not found!");
        }
        Person person = persons.get(name);
        person.setAge(age);
        return persons.put(name, person);
    }

    public Person deletePersonByName(String name) {
        if (!persons.containsKey(name)) {
            throw new RuntimeException("Person not found!");
        }
        return persons.remove(name);
    }

}
