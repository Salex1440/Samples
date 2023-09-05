package com.salex.hateoasexample.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

@Data
@NoArgsConstructor
@ToString
public class Person extends RepresentationModel<Person> {

    private String name;
    private Integer age;

}
