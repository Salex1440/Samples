package com.salex.hateoasexample.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class PersonDto {
    private String name;
    private Integer age;
}
