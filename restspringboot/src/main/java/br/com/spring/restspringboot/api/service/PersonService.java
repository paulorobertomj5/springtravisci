package br.com.spring.restspringboot.api.service;

import br.com.spring.restspringboot.api.entity.PersonResponseEntity;
import br.com.spring.restspringboot.api.model.PersonModel;

import java.util.List;

public interface PersonService {

    List<PersonResponseEntity> personList();
}
