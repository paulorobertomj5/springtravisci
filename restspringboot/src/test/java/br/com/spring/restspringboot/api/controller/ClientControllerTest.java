package br.com.spring.restspringboot.api.controller;

import br.com.spring.restspringboot.api.entity.response.ClientResponse;
import br.com.spring.restspringboot.api.service.ClientService;
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
        ClientController.class
})
public class ClientControllerTest {

    @MockBean
    private ClientService clientService;

    @Test
    public void testFindAll_Success() throws Exception {

        List<ClientResponse> listResponse = new ArrayList<>();
        ClientResponse response = new ClientResponse();
        response.setKey(1);
        response.setName("Paulo");

        listResponse.add(response);

        when(clientService.findAll()).thenReturn(listResponse);

        List<ClientResponse> listResponseExpected = new ArrayList<>();
        ClientResponse responseExpected = new ClientResponse();
        responseExpected.setKey(1);
        responseExpected.setName("Paulo");
        listResponseExpected.add(responseExpected);

        Assert.assertEquals(listResponse, listResponseExpected);

    }

    @Test
    public void testFindById_Success() throws Exception {

        ClientResponse response = new ClientResponse();
        response.setKey(1);
        response.setName("Paulo");


        when(clientService.findById(any())).thenReturn(response);

        ClientResponse responseExpected = new ClientResponse();
        responseExpected.setKey(1);
        responseExpected.setName("Paulo");

        Assert.assertEquals(response, responseExpected);

    }

    @Test
    public void testCreate_Success() throws Exception {

        Integer id = 1;

        when(clientService.create(any())).thenReturn(id);

        ClientResponse response = new ClientResponse();
        response.setKey(1);
        response.setName("Paulo");

        when(clientService.findById(any())).thenReturn(response);

        ClientResponse responseExpected = new ClientResponse();
        responseExpected.setKey(1);
        responseExpected.setName("Paulo");

        Assert.assertEquals(response, responseExpected);

    }

    @Test
    public void testUpdate_Success() throws Exception {

        Integer id = 1;

        when(clientService.update(any())).thenReturn(id);

        ClientResponse response = new ClientResponse();
        response.setKey(1);
        response.setName("Paulo");

        when(clientService.findById(any())).thenReturn(response);

        ClientResponse responseExpected = new ClientResponse();
        responseExpected.setKey(1);
        responseExpected.setName("Paulo");

        Assert.assertEquals(response, responseExpected);

    }

    @Test
    public void testDelete_Success() throws Exception {

        Integer response = 1;

        when(clientService.delete(any())).thenReturn(response);

        Integer responseExpected = 1;

        Assert.assertEquals(response, responseExpected);

    }

    @Test
    public void testFindAll_Error() throws Exception {

        List<ClientResponse> listResponse = new ArrayList<>();
        ClientResponse response = new ClientResponse();
        response.setKey(1);
        response.setName("Paulo");

        listResponse.add(response);

        when(clientService.findAll()).thenReturn(listResponse);

        List<ClientResponse> listResponseExpected = new ArrayList<>();
        ClientResponse responseExpected = new ClientResponse();
        responseExpected.setKey(2);
        responseExpected.setName("Paulo");
        listResponseExpected.add(responseExpected);

        Assert.assertNotEquals(listResponse, listResponseExpected);
    }

    @Test
    public void testFindById_Error() throws Exception {

        ClientResponse response = new ClientResponse();
        response.setKey(1);
        response.setName("Paulo");


        when(clientService.findById(any())).thenReturn(response);

        ClientResponse responseExpected = new ClientResponse();
        responseExpected.setKey(1);
        responseExpected.setName("João");

        Assert.assertNotEquals(response, responseExpected);

    }

    @Test
    public void testCreate_Error() throws Exception {

        Integer response = 1;

        when(clientService.create(any())).thenReturn(response);

        Integer responseExpected = 2;

        Assert.assertNotEquals(response, responseExpected);

    }

    @Test
    public void testUpdate_Error() throws Exception {

        Integer response = 1;

        when(clientService.update(any())).thenReturn(response);

        Integer responseExpected = 2;

        Assert.assertNotEquals(response, responseExpected);

    }

    @Test
    public void testDelete_Error() throws Exception {

        Integer response = 1;

        when(clientService.delete(any())).thenReturn(response);

        Integer responseExpected = 0;

        Assert.assertNotEquals(response, responseExpected);

    }
}
