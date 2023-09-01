package com.salex.hateoasexample.service;

import com.salex.hateoasexample.dto.PersonDto;
import com.salex.hateoasexample.mapper.PersonMapper;
import com.salex.hateoasexample.model.Person;
import com.salex.hateoasexample.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;
    @Autowired
    private PersonMapper mapper;

    public Person createPerson(PersonDto personDto) {
        Person person = mapper.fromDto(personDto);
        return repository.createPerson(person);
    }

    public Person updatePerson(PersonDto personDto) {
        return repository.updatePersonByName(personDto.getName(), personDto.getAge());
    }

    public Person deletePerson(String name) {
        return repository.deletePersonByName(name);
    }

    public Person getPerson(String name) {
        return repository.getPersonByName(name);
    }

    public List<Person> getPersons() {
        return repository.getPersons()
                .values()
                .stream()
                .toList();
    }



}
