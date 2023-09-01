package com.salex.hateoasexample.mapper;

import com.salex.hateoasexample.dto.PersonDto;
import com.salex.hateoasexample.model.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper {

    public Person fromDto(PersonDto dto) {
        Person person = new Person();
        person.setName(dto.getName());
        person.setAge(dto.getAge());
        return person;
    }

}
