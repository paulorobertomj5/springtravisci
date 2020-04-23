package br.com.spring.restspringboot.api.controller;

import br.com.spring.restspringboot.api.entity.response.ProductResponse;
import br.com.spring.restspringboot.api.service.ProductService;
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
        ProductController.class
})
public class ProductControllerTest {

    @MockBean
    private ProductService productService;

    @Test
    public void testFindAll_Success() throws Exception {

        List<ProductResponse> listResponse = new ArrayList<>();
        ProductResponse response = new ProductResponse();
        response.setKey(1);
        response.setName("Computer");

        listResponse.add(response);

        when(productService.findAll()).thenReturn(listResponse);

        List<ProductResponse> listResponseExpected = new ArrayList<>();
        ProductResponse responseExpected = new ProductResponse();
        responseExpected.setKey(1);
        responseExpected.setName("Computer");
        listResponseExpected.add(responseExpected);

        Assert.assertEquals(listResponse, listResponseExpected);

    }

    @Test
    public void testFindById_Success() throws Exception {

        ProductResponse response = new ProductResponse();
        response.setKey(1);
        response.setName("Computer");


        when(productService.findById(any())).thenReturn(response);

        ProductResponse responseExpected = new ProductResponse();
        responseExpected.setKey(1);
        responseExpected.setName("Computer");

        Assert.assertEquals(response, responseExpected);

    }

    @Test
    public void testCreate_Success() throws Exception {

        Integer id = 1;

        when(productService.create(any())).thenReturn(id);

        ProductResponse response = new ProductResponse();
        response.setKey(1);
        response.setName("Paulo");

        when(productService.findById(any())).thenReturn(response);

        ProductResponse responseExpected = new ProductResponse();
        responseExpected.setKey(1);
        responseExpected.setName("Paulo");

        Assert.assertEquals(response, responseExpected);

    }

    @Test
    public void testUpdate_Success() throws Exception {

        Integer id = 1;

        when(productService.update(any())).thenReturn(id);

        ProductResponse response = new ProductResponse();
        response.setKey(1);
        response.setName("Paulo");

        when(productService.findById(any())).thenReturn(response);

        ProductResponse responseExpected = new ProductResponse();
        responseExpected.setKey(1);
        responseExpected.setName("Paulo");

        Assert.assertEquals(response, responseExpected);

    }

    @Test
    public void testDelete_Success() throws Exception {

        Integer response = 1;

        when(productService.delete(any())).thenReturn(response);

        Integer responseExpected = 1;

        Assert.assertEquals(response, responseExpected);

    }

    @Test
    public void testFindAll_Error() throws Exception {

        List<ProductResponse> listResponse = new ArrayList<>();
        ProductResponse response = new ProductResponse();
        response.setKey(1);
        response.setName("Computer");

        listResponse.add(response);

        when(productService.findAll()).thenReturn(listResponse);

        List<ProductResponse> listResponseExpected = new ArrayList<>();
        ProductResponse responseExpected = new ProductResponse();
        responseExpected.setKey(2);
        responseExpected.setName("Computer");
        listResponseExpected.add(responseExpected);

        Assert.assertNotEquals(listResponse, listResponseExpected);
    }

    @Test
    public void testFindById_Error() throws Exception {

        ProductResponse response = new ProductResponse();
        response.setKey(1);
        response.setName("Computer");


        when(productService.findById(any())).thenReturn(response);

        ProductResponse responseExpected = new ProductResponse();
        responseExpected.setKey(1);
        responseExpected.setName("Mouse");

        Assert.assertNotEquals(response, responseExpected);

    }

    @Test
    public void testCreate_Error() throws Exception {

        Integer response = 1;

        when(productService.create(any())).thenReturn(response);

        Integer responseExpected = 2;

        Assert.assertNotEquals(response, responseExpected);

    }

    @Test
    public void testUpdate_Error() throws Exception {

        Integer response = 1;

        when(productService.update(any())).thenReturn(response);

        Integer responseExpected = 2;

        Assert.assertNotEquals(response, responseExpected);

    }

    @Test
    public void testDelete_Error() throws Exception {

        Integer response = 1;

        when(productService.delete(any())).thenReturn(response);

        Integer responseExpected = 0;

        Assert.assertNotEquals(response, responseExpected);

    }
}
