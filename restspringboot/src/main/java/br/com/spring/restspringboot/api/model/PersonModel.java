package br.com.spring.restspringboot.api.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonModel {
    private Integer id;
    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
