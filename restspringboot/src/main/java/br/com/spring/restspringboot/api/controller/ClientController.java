package br.com.spring.restspringboot.api.controller;


import br.com.spring.restspringboot.api.entity.request.ClientRequest;
import br.com.spring.restspringboot.api.entity.response.ClientResponse;
import br.com.spring.restspringboot.api.service.ClientService;
import br.com.spring.restspringboot.api.service.impl.ClientServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Api(value = "Clients")
@RestController
@RequestMapping(value = "V0/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);


    @ApiOperation(value = "Client List All")
    @GetMapping(value = "/")
    public ResponseEntity<Object> findAll() {

        logger.info("Accessing ClientController findAll");

        List<ClientResponse> clientList = clientService.findAll();
        clientList.stream().forEach(p -> p.add(linkTo(methodOn(ClientController.class).findById(p.getKey())).withSelfRel()));

        logger.info("Accessing ClientController findAll clientList = " + clientList);

        if (clientList != null && clientList.size() > 1) {
            return ResponseEntity.status(HttpStatus.OK).body(clientList);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @ApiOperation(value = "Client By id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findById(@NotNull @NotBlank @PathVariable("id") Integer id) {
        logger.info("Accessing ClientController findById id = " + id);

        ClientResponse client = clientService.findById(id);
        client.add(linkTo(methodOn(ClientController.class).findById(id)).withSelfRel());

        logger.info("Accessing ClientController findById client = " + client);

        return ResponseEntity.status(HttpStatus.OK).body(client);

    }

    @ApiOperation(value = "Create Client")
    @PostMapping(value = "/", produces = {"application/json", "application/xml", "application/x-yaml"}, consumes = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<Object> create(@Valid @RequestBody(required = true) ClientRequest requestEntity) {

        logger.info("Accessing ClientController create requestEntity = " + requestEntity);

        Integer create = clientService.create(requestEntity);
        ClientResponse clientResponse = clientService.findById(create);
        clientResponse.add(linkTo(methodOn(ClientController.class).findById(create)).withSelfRel());

        logger.info("Return ClientController create execute = " + create);
        if (create != null && create != 0) {
            return ResponseEntity.status(HttpStatus.CREATED).body(clientResponse);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @ApiOperation(value = "Update Client")
    @PutMapping(value = "/", produces = {"application/json", "application/xml", "application/x-yaml"}, consumes = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<Object> update(@Valid @RequestBody ClientRequest requestEntity) {

        logger.info("Accessing ClientController update requestEntity = " + requestEntity);

        Integer update = clientService.update(requestEntity);

        ClientResponse clientResponse = clientService.findById(requestEntity.getKey());
        clientResponse.add(linkTo(methodOn(ClientController.class).findById(clientResponse.getKey())).withSelfRel());

        logger.info("Accessing ClientController update execute = " + update);
        if (update != null && update != 0) {
            return ResponseEntity.status(HttpStatus.OK).body(clientResponse);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @ApiOperation(value = "Delete Client")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer id) {
        logger.info("Accessing ClientController update id= " + id);
        Integer delete = clientService.delete(id);
        logger.info("Accessing ClientController update execute = " + delete);

        if (delete != null && delete != 0) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
}
