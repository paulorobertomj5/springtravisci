package br.com.spring.restspringboot.api.dao;

import br.com.spring.restspringboot.api.model.PersonModel;

import java.util.List;

public interface PersonDAO {

    List<PersonModel> personList();
}
