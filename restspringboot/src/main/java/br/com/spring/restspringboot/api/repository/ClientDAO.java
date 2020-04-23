package br.com.spring.restspringboot.api.repository;

import br.com.spring.restspringboot.api.model.ClientModel;

import java.util.List;

public interface ClientDAO {

    List<ClientModel> findAll();

    ClientModel findById(Integer clientId);

    Integer create(ClientModel clientModele);

    Integer update(ClientModel clientModel);

    Integer delete(Integer clientId);
}
