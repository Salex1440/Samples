package com.salex.hateoasexample.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Person {

    private String name;
    private Integer age;

}
