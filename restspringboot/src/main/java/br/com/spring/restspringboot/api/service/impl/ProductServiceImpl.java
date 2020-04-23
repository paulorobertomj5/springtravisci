package br.com.spring.restspringboot.api.service.impl;

import br.com.spring.restspringboot.api.entity.request.ProductRequest;
import br.com.spring.restspringboot.api.entity.response.ProductResponse;
import br.com.spring.restspringboot.api.model.ProductModel;
import br.com.spring.restspringboot.api.repository.ProductDAO;
import br.com.spring.restspringboot.api.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDAO productDAO;

    @Override
    public List<ProductResponse> findAll() {
        List<ProductModel> personModelList = productDAO.findAll();

        if (personModelList != null && personModelList.size() > 1) {
            List<ProductResponse> responses = new ArrayList<>();

            personModelList.forEach(
                    model -> {
                        ProductResponse response = new ProductResponse();
                        BeanUtils.copyProperties(model, response);
                        responses.add(response);
                    }
            );
            return responses;
        }

        return new ArrayList<>();
    }

    @Override
    public ProductResponse findById(Integer id) {
        ProductModel productModel = productDAO.findById(id);
        ProductResponse productResponse = new ProductResponse();
        BeanUtils.copyProperties(productModel, productResponse);

        return productResponse;
    }

    @Override
    public Integer create(ProductRequest productRequest) {
        ProductModel productModel = ProductModel.builder()
                .name(productRequest.getName())
                .qtd(productRequest.getQtd())
                .price(productRequest.getPrice()).build();
        return productDAO.create(productModel);
    }

    @Override
    public Integer update(ProductRequest productRequest) {
        ProductModel productModel = ProductModel.builder()
                .key(productRequest.getKey())
                .name(productRequest.getName())
                .qtd(productRequest.getQtd())
                .price(productRequest.getPrice()).build();
        return productDAO.update(productModel);
    }

    @Override
    public Integer delete(Integer id) {
        return productDAO.delete(id);
    }
}

