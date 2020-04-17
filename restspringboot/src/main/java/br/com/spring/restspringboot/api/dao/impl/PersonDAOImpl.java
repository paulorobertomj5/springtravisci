package br.com.spring.restspringboot.api.dao.impl;

import br.com.spring.restspringboot.api.dao.PersonDAO;
import br.com.spring.restspringboot.api.dao.mapper.PersonMapper;
import br.com.spring.restspringboot.api.model.PersonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PersonDAOImpl implements PersonDAO {

    @Autowired
    private DataSource dataSource;

    private NamedParameterJdbcTemplate namedJdbcTemplate;

    @PostConstruct
    private void postConstruct() {

        namedJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<PersonModel> personList(){

        try {
            String sql = "select * from person";
            return namedJdbcTemplate.query(sql, new PersonMapper());

        }catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }
}
