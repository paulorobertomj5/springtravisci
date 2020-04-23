package br.com.spring.restspringboot.api.repository;

import br.com.spring.restspringboot.api.model.OrderModel;

import java.util.List;

public interface OrderDAO {

    List<OrderModel> findAll();

    OrderModel findByClientId(Integer clientId);

    OrderModel findById(Integer id);

    Integer create(OrderModel orderModel);

    Integer update(OrderModel orderModel);

    Integer delete(Integer id);
}
