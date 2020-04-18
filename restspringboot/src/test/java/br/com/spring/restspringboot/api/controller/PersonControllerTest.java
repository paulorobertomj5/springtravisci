package br.com.spring.restspringboot.api.controller;

import br.com.spring.restspringboot.api.entity.PersonResponseEntity;
import br.com.spring.restspringboot.api.service.PersonService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        PersonController.class
})
public class PersonControllerTest {

    @Autowired
    private PersonController personController;

    @MockBean
    private PersonService personService;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setup() {
        this.objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(personController)
                .build();
    }

    @Test
    public void testPersonList_Success() throws Exception {

        List<PersonResponseEntity> listResponse = new ArrayList<>();
        PersonResponseEntity response = new PersonResponseEntity();
        response.setId(1);
        response.setName("Marcos");

        listResponse.add(response);

        when(personService.personList()).thenReturn(listResponse);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/person/personList")
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        String expectedId = "1";
        String expectedName = "Marcos";

        assertNotNull(result);
        assertNotNull(result.getResponse());

        String jsonResult = result.getResponse().getContentAsString();
        assertNotNull(jsonResult);
    }

}
