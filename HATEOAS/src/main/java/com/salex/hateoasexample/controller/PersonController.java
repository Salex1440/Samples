package com.salex.hateoasexample.controller;

import com.salex.hateoasexample.dto.PersonDto;
import com.salex.hateoasexample.model.Person;
import com.salex.hateoasexample.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/create")
    public Person createPerson(@RequestBody PersonDto personDto) {
        return personService.createPerson(personDto);
    }

    @PostMapping("/update")
    public Person updatePerson(@RequestBody PersonDto personDto) {
        return personService.updatePerson(personDto);
    }

    @DeleteMapping(path = "/{name}")
    public Person deletePerson(@PathVariable("name") String name) {
        return personService.deletePerson(name);
    }

    @GetMapping(path = "/{name}")
    public Person getPerson(@PathVariable("name") String name) {
        return personService.getPerson(name);
    }

    @GetMapping(path = "/all")
    public List<Person> getPerson() {
        return personService.getPersons();
    }

}
