package br.com.spring.restspringboot.api.service;

import br.com.spring.restspringboot.api.entity.request.OrderRequest;
import br.com.spring.restspringboot.api.entity.response.OrderResponse;

import java.util.List;

public interface OrderService {

    List<OrderResponse> findAll();

    OrderResponse findByClientId(Integer clientId);

    OrderResponse findById(Integer id);

    Integer create(OrderRequest orderRequest);

    Integer update(OrderRequest orderRequest);

    Integer delete(Integer id);


}
