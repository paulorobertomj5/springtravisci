package br.com.spring.restspringboot.api.service.impl;

import br.com.spring.restspringboot.api.dao.PersonDAO;
import br.com.spring.restspringboot.api.entity.PersonResponseEntity;
import br.com.spring.restspringboot.api.model.PersonModel;
import br.com.spring.restspringboot.api.service.PersonService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDAO personDAO;

    @Override
    public List<PersonResponseEntity> personList(){
        List<PersonModel> personModelList = personDAO.personList();

        if(personModelList != null && personModelList.size() > 1) {
            List<PersonResponseEntity> responses = new ArrayList<>();

            personModelList.forEach(
                    model ->{
                        PersonResponseEntity response = new PersonResponseEntity();
                        BeanUtils.copyProperties(model, response);
                        responses.add(response);
                    }
            );
            return responses;
        }

        return new ArrayList<>();
    }
}
