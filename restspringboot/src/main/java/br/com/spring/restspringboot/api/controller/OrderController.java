package br.com.spring.restspringboot.api.controller;


import br.com.spring.restspringboot.api.entity.request.OrderRequest;
import br.com.spring.restspringboot.api.entity.response.OrderResponse;
import br.com.spring.restspringboot.api.service.OrderService;
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

@Api(value = "Orders")
@RestController
@RequestMapping(value = "V0/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    Logger logger = LoggerFactory.getLogger(OrderController.class);


    @ApiOperation(value = "Order List All")
    @GetMapping(value = "/")
    public ResponseEntity<Object> findAll() {
        logger.info("Accessing OrderController findAll");

        List<OrderResponse> productList = orderService.findAll();
        productList.stream().forEach(p -> p.add(linkTo(methodOn(OrderController.class).findById(p.getKey())).withSelfRel()));

        logger.info("Accessing OrderController findAll productList= " + productList);

        if (productList != null && productList.size() > 1) {
            return ResponseEntity.status(HttpStatus.OK).body(productList);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @ApiOperation(value = "Client By id")
    @GetMapping(value = "/client/{id}")
    public ResponseEntity<Object> findByClientId(@NotNull @NotBlank @PathVariable("id") Integer id) {
        logger.info("Accessing OrderController findAll id = " + id);

        OrderResponse product = orderService.findByClientId(id);
        product.add(linkTo(methodOn(OrderController.class).findByClientId(product.getClient().getKey())).withSelfRel());

        logger.info("Accessing OrderController findAll product = " + product);

        return ResponseEntity.status(HttpStatus.OK).body(product);

    }

    @ApiOperation(value = "Order By id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findById(@NotNull @NotBlank @PathVariable("id") Integer id) {
        logger.info("Accessing OrderController findById id = " + id);

        OrderResponse product = orderService.findById(id);
        product.add(linkTo(methodOn(OrderController.class).findById(id)).withSelfRel());

        logger.info("Accessing OrderController findById product = " + product);

        return ResponseEntity.status(HttpStatus.OK).body(product);

    }


    @ApiOperation(value = "Create Client")
    @PostMapping(value = "/", produces = {"application/json", "application/xml", "application/x-yaml"}, consumes = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<Object> create(@Valid @RequestBody(required = true) OrderRequest requestEntity) {

        logger.info("Accessing OrderController create requestEntity = " + requestEntity);

        Integer create = orderService.create(requestEntity);
        OrderResponse clientResponse = orderService.findById(create);
        clientResponse.add(linkTo(methodOn(OrderController.class).findById(create)).withSelfRel());

        logger.info("Accessing OrderController create execute = " + create);

        if (create != null && create != 0) {
            return ResponseEntity.status(HttpStatus.CREATED).body(clientResponse);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @ApiOperation(value = "Update Client")
    @PutMapping(value = "/", produces = {"application/json", "application/xml", "application/x-yaml"}, consumes = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<Object> update(@Valid @RequestBody OrderRequest requestEntity) {
        logger.info("Accessing OrderController update requestEntity = " + requestEntity);

        Integer update = orderService.update(requestEntity);
        OrderResponse clientResponse = orderService.findById(requestEntity.getKey());
        clientResponse.add(linkTo(methodOn(OrderController.class).findById(requestEntity.getKey())).withSelfRel());
        logger.info("Accessing OrderController update execute = " + update);

        if (update != null && update != 0) {
            return ResponseEntity.status(HttpStatus.OK).body(clientResponse);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @ApiOperation(value = "Delete Client")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer id) {
        logger.info("Accessing OrderController delete id = " + id);
        Integer delete = orderService.delete(id);
        logger.info("Accessing OrderController delete execute = " + delete);
        if (delete != null && delete != 0) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
}
