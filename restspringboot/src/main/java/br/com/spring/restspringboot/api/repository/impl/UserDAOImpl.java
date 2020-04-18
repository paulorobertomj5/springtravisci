package br.com.spring.restspringboot.api.repository.impl;

import br.com.spring.restspringboot.api.model.UserModel;
import br.com.spring.restspringboot.api.repository.UserDAO;
import br.com.spring.restspringboot.api.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDAOImpl implements UserDAO {
    @Autowired
    DataSource dataSource;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @PostConstruct
    private void postConstruct(){
        namedParameterJdbcTemplate =  new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<UserModel> getUsers() {
        return namedParameterJdbcTemplate.query("SELECT * FROM USER", new UserMapper());
    }

    @Override
    public UserModel getFindByUserName(String username) {

        Map<String, Object> parameters = new HashMap<>();
        parameters.put(UserMapper.USERNAME, username);

        return namedParameterJdbcTemplate.queryForObject("SELECT * FROM USER where username = :username ", parameters, new UserMapper());
    }
}
