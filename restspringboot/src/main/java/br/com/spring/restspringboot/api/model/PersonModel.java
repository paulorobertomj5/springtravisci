package br.com.spring.restspringboot.api.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonModel {
    private Integer id;
    private String name;
}
