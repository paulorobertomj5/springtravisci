package br.com.spring.restspringboot.api.service;

import br.com.spring.restspringboot.api.entity.request.ClientRequest;
import br.com.spring.restspringboot.api.entity.response.ClientResponse;

import java.util.List;

public interface ClientService {

    List<ClientResponse> findAll();

    ClientResponse findById(Integer id);

    Integer create(ClientRequest name);

    Integer update(ClientRequest client);

    Integer delete(Integer id);

}
