package br.com.spring.restspringboot.api.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonResponseEntity {

    private Integer id;
    private String name;
}
