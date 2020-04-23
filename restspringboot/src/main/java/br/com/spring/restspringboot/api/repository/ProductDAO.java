package br.com.spring.restspringboot.api.repository;

import br.com.spring.restspringboot.api.model.ProductModel;

import java.util.List;

public interface ProductDAO {

    List<ProductModel> findAll();

    ProductModel findById(Integer id);

    Integer create(ProductModel productModel);

    Integer update(ProductModel productModel);

    Integer delete(Integer id);
}
