package br.com.spring.restspringboot.api.service;

import br.com.spring.restspringboot.api.entity.request.ProductRequest;
import br.com.spring.restspringboot.api.entity.response.ProductResponse;

import java.util.List;

public interface ProductService {

    List<ProductResponse> findAll();

    ProductResponse findById(Integer id);

    Integer create(ProductRequest name);

    Integer update(ProductRequest client);

    Integer delete(Integer id);

}
