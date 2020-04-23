package br.com.spring.restspringboot.api.controller;

import br.com.spring.restspringboot.api.entity.response.ClientResponse;
import br.com.spring.restspringboot.api.entity.response.OrderResponse;
import br.com.spring.restspringboot.api.entity.response.ProductResponse;
import br.com.spring.restspringboot.api.service.OrderService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        OrderController.class
})
public class OrderControllerTest {

    @MockBean
    private OrderService orderService;

    @Test
    public void testFindAll_Success() throws Exception {

        List<OrderResponse> listResponse = new ArrayList<>();
        ClientResponse clientResponse = new ClientResponse();
        ProductResponse productResponse = new ProductResponse();
        OrderResponse orderResponse = new OrderResponse();

        clientResponse.setKey(1);
        clientResponse.setName("Paulo");

        productResponse.setKey(1);
        productResponse.setName("Computer");

        orderResponse.setKey(1);
        orderResponse.setClient(clientResponse);
        orderResponse.setProduct(productResponse);
        orderResponse.setQtd(1);
        orderResponse.setPrice(100D);

        listResponse.add(orderResponse);

        when(orderService.findAll()).thenReturn(listResponse);

        List<OrderResponse> listResponseExpected = new ArrayList<>();
        ClientResponse clientResponseExpected = new ClientResponse();
        ProductResponse productResponseExpected = new ProductResponse();
        OrderResponse orderResponseExpected = new OrderResponse();

        clientResponseExpected.setKey(1);
        clientResponseExpected.setName("Paulo");

        productResponseExpected.setKey(1);
        productResponseExpected.setName("Computer");

        orderResponseExpected.setKey(1);
        orderResponseExpected.setClient(clientResponseExpected);
        orderResponseExpected.setProduct(productResponseExpected);
        orderResponseExpected.setQtd(1);
        orderResponseExpected.setPrice(100D);

        listResponseExpected.add(orderResponseExpected);

        Assert.assertEquals(listResponse, listResponseExpected);

    }

    @Test
    public void testFindById_Success() throws Exception {

        ClientResponse clientResponse = new ClientResponse();
        ProductResponse productResponse = new ProductResponse();
        OrderResponse orderResponse = new OrderResponse();

        clientResponse.setKey(1);
        clientResponse.setName("Paulo");

        productResponse.setKey(1);
        productResponse.setName("Computer");

        orderResponse.setKey(1);
        orderResponse.setClient(clientResponse);
        orderResponse.setProduct(productResponse);
        orderResponse.setQtd(1);
        orderResponse.setPrice(100D);


        when(orderService.findById(any())).thenReturn(orderResponse);

        ClientResponse clientResponseExpected = new ClientResponse();
        ProductResponse productResponseExpected = new ProductResponse();
        OrderResponse orderResponseExpected = new OrderResponse();

        clientResponseExpected.setKey(1);
        clientResponseExpected.setName("Paulo");

        productResponseExpected.setKey(1);
        productResponseExpected.setName("Computer");

        orderResponseExpected.setKey(1);
        orderResponseExpected.setClient(clientResponseExpected);
        orderResponseExpected.setProduct(productResponseExpected);
        orderResponseExpected.setQtd(1);
        orderResponseExpected.setPrice(100D);



        Assert.assertEquals(orderResponse, orderResponseExpected);

    }

    @Test
    public void testCreate_Success() throws Exception {

        Integer id = 1;

        when(orderService.create(any())).thenReturn(id);

        OrderResponse orderResponse = new OrderResponse();
        ClientResponse clientResponse = new ClientResponse();
        ProductResponse productResponse = new ProductResponse();
        clientResponse.setKey(1);
        clientResponse.setName("Paulo");

        productResponse.setKey(1);
        productResponse.setName("Computer");

        orderResponse.setKey(1);
        orderResponse.setClient(clientResponse);
        orderResponse.setProduct(productResponse);
        orderResponse.setQtd(1);
        orderResponse.setPrice(100D);

        when(orderService.findById(any())).thenReturn(orderResponse);

        OrderResponse orderResponseExpected = new OrderResponse();
        ClientResponse clientResponseExpected = new ClientResponse();
        ProductResponse productResponseExpected = new ProductResponse();
        clientResponseExpected.setKey(1);
        clientResponseExpected.setName("Paulo");

        productResponseExpected.setKey(1);
        productResponseExpected.setName("Computer");

        orderResponseExpected.setKey(1);
        orderResponseExpected.setClient(clientResponse);
        orderResponseExpected.setProduct(productResponse);
        orderResponseExpected.setQtd(1);
        orderResponseExpected.setPrice(100D);

        Assert.assertEquals(orderResponse, orderResponseExpected);

    }

    @Test
    public void testUpdate_Success() throws Exception {

        Integer id = 1;

        when(orderService.update(any())).thenReturn(id);

        OrderResponse orderResponse = new OrderResponse();
        ClientResponse clientResponse = new ClientResponse();
        ProductResponse productResponse = new ProductResponse();
        clientResponse.setKey(1);
        clientResponse.setName("Paulo");

        productResponse.setKey(1);
        productResponse.setName("Computer");

        orderResponse.setKey(1);
        orderResponse.setClient(clientResponse);
        orderResponse.setProduct(productResponse);
        orderResponse.setQtd(1);
        orderResponse.setPrice(100D);

        when(orderService.findById(any())).thenReturn(orderResponse);

        OrderResponse orderResponseExpected = new OrderResponse();
        ClientResponse clientResponseExpected = new ClientResponse();
        ProductResponse productResponseExpected = new ProductResponse();
        clientResponseExpected.setKey(1);
        clientResponseExpected.setName("Paulo");

        productResponseExpected.setKey(1);
        productResponseExpected.setName("Computer");

        orderResponseExpected.setKey(1);
        orderResponseExpected.setClient(clientResponse);
        orderResponseExpected.setProduct(productResponse);
        orderResponseExpected.setQtd(1);
        orderResponseExpected.setPrice(100D);

        Assert.assertEquals(orderResponse, orderResponseExpected);

    }

    @Test
    public void testDelete_Success() throws Exception {

        Integer response = 1;

        when(orderService.delete(any())).thenReturn(response);

        Integer responseExpected = 1;

        Assert.assertEquals(response, responseExpected);

    }

    @Test
    public void testFindAll_Error() throws Exception {

        List<OrderResponse> listResponse = new ArrayList<>();
        ClientResponse clientResponse = new ClientResponse();
        ProductResponse productResponse = new ProductResponse();
        OrderResponse orderResponse = new OrderResponse();

        clientResponse.setKey(1);
        clientResponse.setName("Paulo");

        productResponse.setKey(1);
        productResponse.setName("Computer");

        orderResponse.setKey(1);
        orderResponse.setClient(clientResponse);
        orderResponse.setProduct(productResponse);
        orderResponse.setQtd(1);
        orderResponse.setPrice(100D);

        listResponse.add(orderResponse);

        when(orderService.findAll()).thenReturn(listResponse);

        List<OrderResponse> listResponseExpected = new ArrayList<>();
        ClientResponse clientResponseExpected = new ClientResponse();
        ProductResponse productResponseExpected = new ProductResponse();
        OrderResponse orderResponseExpected = new OrderResponse();

        clientResponseExpected.setKey(1);
        clientResponseExpected.setName("Paulo");

        productResponseExpected.setKey(1);
        productResponseExpected.setName("Computer");

        orderResponseExpected.setKey(1);
        orderResponseExpected.setClient(clientResponseExpected);
        orderResponseExpected.setProduct(productResponseExpected);
        orderResponseExpected.setQtd(1);
        orderResponseExpected.setPrice(200D);

        listResponseExpected.add(orderResponseExpected);

        Assert.assertNotEquals(listResponse, listResponseExpected);
    }

    @Test
    public void testFindById_Error() throws Exception {

        ClientResponse clientResponse = new ClientResponse();
        ProductResponse productResponse = new ProductResponse();
        OrderResponse orderResponse = new OrderResponse();

        clientResponse.setKey(1);
        clientResponse.setName("Paulo");

        productResponse.setKey(1);
        productResponse.setName("Computer");

        orderResponse.setKey(1);
        orderResponse.setClient(clientResponse);
        orderResponse.setProduct(productResponse);
        orderResponse.setQtd(1);
        orderResponse.setPrice(100D);


        when(orderService.findById(any())).thenReturn(orderResponse);

        ClientResponse clientResponseExpected = new ClientResponse();
        ProductResponse productResponseExpected = new ProductResponse();
        OrderResponse orderResponseExpected = new OrderResponse();

        clientResponseExpected.setKey(1);
        clientResponseExpected.setName("Paulo");

        productResponseExpected.setKey(1);
        productResponseExpected.setName("Mouse");

        orderResponseExpected.setKey(1);
        orderResponseExpected.setClient(clientResponseExpected);
        orderResponseExpected.setProduct(productResponseExpected);
        orderResponseExpected.setQtd(1);
        orderResponseExpected.setPrice(100D);

        Assert.assertNotEquals(orderResponse, orderResponseExpected);

    }

    @Test
    public void testCreate_Error() throws Exception {

        Integer id = 1;

        when(orderService.create(any())).thenReturn(id);

        OrderResponse orderResponse = new OrderResponse();
        ClientResponse clientResponse = new ClientResponse();
        ProductResponse productResponse = new ProductResponse();
        clientResponse.setKey(1);
        clientResponse.setName("Paulo");

        productResponse.setKey(1);
        productResponse.setName("Computer");

        orderResponse.setKey(1);
        orderResponse.setClient(clientResponse);
        orderResponse.setProduct(productResponse);
        orderResponse.setQtd(1);
        orderResponse.setPrice(100D);

        when(orderService.findById(any())).thenReturn(orderResponse);

        OrderResponse orderResponseExpected = new OrderResponse();
        ClientResponse clientResponseExpected = new ClientResponse();
        ProductResponse productResponseExpected = new ProductResponse();
        clientResponseExpected.setKey(1);
        clientResponseExpected.setName("Paulo");

        productResponseExpected.setKey(1);
        productResponseExpected.setName("Computer");

        orderResponseExpected.setKey(1);
        orderResponseExpected.setClient(clientResponse);
        orderResponseExpected.setProduct(productResponse);
        orderResponseExpected.setQtd(1);
        orderResponseExpected.setPrice(300D);

        Assert.assertNotEquals(orderResponse, orderResponseExpected);

    }

    @Test
    public void testUpdate_Error() throws Exception {

        Integer id = 1;

        when(orderService.update(any())).thenReturn(id);

        OrderResponse orderResponse = new OrderResponse();
        ClientResponse clientResponse = new ClientResponse();
        ProductResponse productResponse = new ProductResponse();
        clientResponse.setKey(1);
        clientResponse.setName("Paulo");

        productResponse.setKey(1);
        productResponse.setName("Computer");

        orderResponse.setKey(1);
        orderResponse.setClient(clientResponse);
        orderResponse.setProduct(productResponse);
        orderResponse.setQtd(1);
        orderResponse.setPrice(100D);

        when(orderService.findById(any())).thenReturn(orderResponse);

        OrderResponse orderResponseExpected = new OrderResponse();
        ClientResponse clientResponseExpected = new ClientResponse();
        ProductResponse productResponseExpected = new ProductResponse();
        clientResponseExpected.setKey(1);
        clientResponseExpected.setName("Paulo");

        productResponseExpected.setKey(1);
        productResponseExpected.setName("Computer");

        orderResponseExpected.setKey(1);
        orderResponseExpected.setClient(clientResponse);
        orderResponseExpected.setProduct(productResponse);
        orderResponseExpected.setQtd(1);
        orderResponseExpected.setPrice(200D);

        Assert.assertNotEquals(orderResponse, orderResponseExpected);

    }

    @Test
    public void testDelete_Error() throws Exception {

        Integer response = 1;

        when(orderService.delete(any())).thenReturn(response);

        Integer responseExpected = 0;

        Assert.assertNotEquals(response, responseExpected);

    }
}
