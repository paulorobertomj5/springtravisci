package br.com.spring.restspringboot.api.controller;


import br.com.spring.restspringboot.api.entity.request.ProductRequest;
import br.com.spring.restspringboot.api.entity.response.ProductResponse;
import br.com.spring.restspringboot.api.service.ProductService;
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

@Api(value = "Products")
@RestController
@RequestMapping(value = "V0/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @ApiOperation(value = "Product List All")
    @GetMapping(value = "/")
    public ResponseEntity<Object> findAll() {
        logger.info("Accessing ProductController findAll");

        List<ProductResponse> productList = productService.findAll();
        productList.stream().forEach(p -> p.add(linkTo(methodOn(ProductController.class).findById(p.getKey())).withSelfRel()));

        logger.info("Accessing ProductController findAll productList = " + productList);

        if (productList != null && productList.size() > 1) {
            return ResponseEntity.status(HttpStatus.OK).body(productList);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @ApiOperation(value = "Client By id")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> findById(@NotNull @NotBlank @PathVariable("id") Integer id) {
        logger.info("Accessing ProductController findById id = " + id);
        ProductResponse product = productService.findById(id);
        product.add(linkTo(methodOn(ProductController.class).findById(id)).withSelfRel());

        logger.info("Accessing ProductController findById product = " + product);
        return ResponseEntity.status(HttpStatus.OK).body(product);

    }

    @ApiOperation(value = "Create Client")
    @PostMapping(value = "/", produces = {"application/json", "application/xml", "application/x-yaml"}, consumes = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<Object> create(@Valid @RequestBody(required = true) ProductRequest requestEntity) {
        logger.info("Accessing ProductController create requestEntity = " + requestEntity);

        Integer create = productService.create(requestEntity);
        ProductResponse clientResponse = productService.findById(create);
        clientResponse.add(linkTo(methodOn(ProductController.class).findById(create)).withSelfRel());
        logger.info("Accessing ProductController create execute = " + create);
        if (create != null && create != 0) {
            return ResponseEntity.status(HttpStatus.CREATED).body(clientResponse);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @ApiOperation(value = "Update Client")
    @PutMapping(value = "/", produces = {"application/json", "application/xml", "application/x-yaml"}, consumes = {"application/json", "application/xml", "application/x-yaml"})
    public ResponseEntity<Object> update(@Valid @RequestBody ProductRequest requestEntity) {
        logger.info("Accessing ProductController update requestEntity = " + requestEntity);
        Integer update = productService.update(requestEntity);
        ProductResponse clientResponse = productService.findById(requestEntity.getKey());
        clientResponse.add(linkTo(methodOn(ProductController.class).findById(requestEntity.getKey())).withSelfRel());
        logger.info("Accessing ProductController update execute = " + update);
        if (update != null && update != 0) {
            return ResponseEntity.status(HttpStatus.OK).body(clientResponse);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @ApiOperation(value = "Delete Client")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer id) {
        logger.info("Accessing ProductController delete id = " + id);
        Integer delete = productService.delete(id);
        logger.info("Accessing ProductController delete execute = " + delete);
        if (delete != null && delete != 0) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
}
