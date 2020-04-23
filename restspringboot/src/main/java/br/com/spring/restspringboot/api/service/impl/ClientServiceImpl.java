package br.com.spring.restspringboot.api.service.impl;

import br.com.spring.restspringboot.api.entity.request.ClientRequest;
import br.com.spring.restspringboot.api.entity.response.ClientResponse;
import br.com.spring.restspringboot.api.model.ClientModel;
import br.com.spring.restspringboot.api.repository.ClientDAO;
import br.com.spring.restspringboot.api.service.ClientService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDAO clientDAO;

    @Override
    public List<ClientResponse> findAll() {

        List<ClientModel> personModelList = clientDAO.findAll();

        if (personModelList != null && personModelList.size() > 1) {
            List<ClientResponse> responses = new ArrayList<>();

            personModelList.forEach(
                    model -> {
                        ClientResponse response = new ClientResponse();
                        BeanUtils.copyProperties(model, response);
                        responses.add(response);
                    }
            );
            return responses;
        }

        return new ArrayList<>();
    }

    @Override
    public ClientResponse findById(Integer id) {
        ClientModel clientModel = clientDAO.findById(id);
        ClientResponse clientResponse = new ClientResponse();
        BeanUtils.copyProperties(clientModel, clientResponse);

        return clientResponse;
    }

    @Override
    public Integer create(ClientRequest clientRequest) {
        ClientModel clientModel = ClientModel.builder()
                .name(clientRequest.getName()).build();
        return clientDAO.create(clientModel);
    }

    @Override
    public Integer update(ClientRequest clientRequest) {
        ClientModel clientModel = ClientModel.builder()
                .key(clientRequest.getKey())
                .name(clientRequest.getName()).build();
        return clientDAO.update(clientModel);
    }

    @Override
    public Integer delete(Integer id) {
        return clientDAO.delete(id);
    }
}

