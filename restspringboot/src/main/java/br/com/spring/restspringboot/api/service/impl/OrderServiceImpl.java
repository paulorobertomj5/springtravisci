package br.com.spring.restspringboot.api.service.impl;

import br.com.spring.restspringboot.api.entity.request.OrderRequest;
import br.com.spring.restspringboot.api.entity.response.ClientResponse;
import br.com.spring.restspringboot.api.entity.response.OrderResponse;
import br.com.spring.restspringboot.api.entity.response.ProductResponse;
import br.com.spring.restspringboot.api.model.ClientModel;
import br.com.spring.restspringboot.api.model.OrderModel;
import br.com.spring.restspringboot.api.model.ProductModel;
import br.com.spring.restspringboot.api.repository.ClientDAO;
import br.com.spring.restspringboot.api.repository.OrderDAO;
import br.com.spring.restspringboot.api.repository.ProductDAO;
import br.com.spring.restspringboot.api.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private ClientDAO clientDAO;
    @Autowired
    private ProductDAO productAO;


    @Override
    public List<OrderResponse> findAll() {
        List<OrderModel> personModelList = orderDAO.findAll();

        if (personModelList != null && personModelList.size() > 1) {
            List<OrderResponse> responses = new ArrayList<>();

            personModelList.forEach(
                    model -> {
                        OrderResponse response = new OrderResponse();
                        BeanUtils.copyProperties(model, response);
                        response.setClient(new ClientResponse());
                        response.setProduct(new ProductResponse());
                        response.setClient(fillClientResponse(model.getClientId()));
                        response.setProduct(fillProductResponse(model.getClientId()));

                        responses.add(response);
                    }
            );

            return responses;
        }

        return new ArrayList<>();
    }

    @Override
    public OrderResponse findByClientId(Integer id) {
        OrderModel productModel = orderDAO.findByClientId(id);
        OrderResponse productResponse = new OrderResponse();
        BeanUtils.copyProperties(productModel, productResponse);

        return productResponse;
    }

    @Override
    public OrderResponse findById(Integer id) {
        OrderModel productModel = orderDAO.findById(id);
        OrderResponse productResponse = new OrderResponse();
        BeanUtils.copyProperties(productModel, productResponse);

        return productResponse;
    }


    @Override
    public Integer create(OrderRequest orderRequest) {
        OrderModel productModel = OrderModel.builder()
                .clientId(orderRequest.getClientId())
                .productId(orderRequest.getProductId())
                .qtd(orderRequest.getQtd())
                .price(orderRequest.getPrice()).build();
        return orderDAO.create(productModel);
    }

    @Override
    public Integer update(OrderRequest orderRequest) {
        OrderModel productModel = OrderModel.builder()
                .key(orderRequest.getKey())
                .clientId(orderRequest.getClientId())
                .productId(orderRequest.getProductId())
                .qtd(orderRequest.getQtd())
                .price(orderRequest.getPrice()).build();
        return orderDAO.update(productModel);
    }

    private ClientResponse fillClientResponse(Integer id) {
        ClientResponse clientResponse = new ClientResponse();
        ClientModel clientModel = clientDAO.findById(id);
        clientResponse.setKey(clientModel.getKey() != null ? clientModel.getKey() : null);
        clientResponse.setName(clientModel.getName());
        return clientResponse;
    }

    private ProductResponse fillProductResponse(Integer id) {
        ProductResponse productResponse = new ProductResponse();
        ProductModel productModel = productAO.findById(id);
        productResponse.setKey(productModel.getKey());
        productResponse.setName(productModel.getName());
        productResponse.setQtd(productModel.getQtd());
        productResponse.setPrice(productModel.getPrice());
        return productResponse;
    }

    @Override
    public Integer delete(Integer id) {
        return orderDAO.delete(id);
    }
}

