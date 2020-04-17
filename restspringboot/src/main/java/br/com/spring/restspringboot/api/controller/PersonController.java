package br.com.spring.restspringboot.api.controller;

import br.com.spring.restspringboot.api.entity.PersonResponseEntity;
import br.com.spring.restspringboot.api.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value="Person")
@RestController
@RequestMapping(value="person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @ApiOperation(value = "Person List All")
    @GetMapping(value = "/personlist")
    public ResponseEntity<Object> personList(){
        List<PersonResponseEntity> personList = personService.personList();

        if(personList != null && personList.size() > 1){
            return ResponseEntity.status(HttpStatus.OK).body(personList);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(personList);
        }
    }

    @GetMapping(value = "/teste")
    public ResponseEntity<Object> teste(){
        return ResponseEntity.status(HttpStatus.OK).body("\"Teste\"");

    }
}
