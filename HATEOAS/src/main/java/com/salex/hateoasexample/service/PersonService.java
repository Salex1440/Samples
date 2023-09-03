package com.salex.hateoasexample.service;

import com.salex.hateoasexample.controller.PersonController;
import com.salex.hateoasexample.dto.PersonDto;
import com.salex.hateoasexample.mapper.PersonMapper;
import com.salex.hateoasexample.model.Person;
import com.salex.hateoasexample.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;
    @Autowired
    private PersonMapper mapper;

    public Person createPerson(PersonDto personDto) {
        Person person = repository.createPerson(mapper.fromDto(personDto));
        Link selfRel = linkTo(PersonController.class).slash(person.getName()).withSelfRel();
        person.add(selfRel);
        Link all = linkTo(methodOn(PersonController.class).getPersons()).withRel("all");
        person.add(all);
        Link update = linkTo(methodOn(PersonController.class).updatePerson(null))
            .withRel("post");
        person.add(update);
        Link delete = linkTo(methodOn(PersonController.class).deletePerson(person.getName())).withRel("delete");
        person.add(delete);
        return person;
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
