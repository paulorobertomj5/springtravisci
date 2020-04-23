package br.com.spring.restspringboot.api.repository.impl;

import br.com.spring.restspringboot.api.model.ClientModel;
import br.com.spring.restspringboot.api.repository.ClientDAO;
import br.com.spring.restspringboot.api.repository.mapper.ClientMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ClientDAOImpl implements ClientDAO {

    @Autowired
    private DataSource dataSource;

    private NamedParameterJdbcTemplate namedJdbcTemplate;

    Logger logger = LoggerFactory.getLogger(ClientDAOImpl.class);


    @PostConstruct
    private void postConstruct() {

        namedJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<ClientModel> findAll() {

        try {
            logger.info("Accessing ClientDAOImpl findAll");

            String sql = "SELECT * FROM client";
            return namedJdbcTemplate.query(sql, new ClientMapper());

        } catch (Exception e) {
            logger.info("Accessing ClientDAOImpl findAll error = " + e.getMessage());

        }

        return new ArrayList<>();
    }

    @Override
    public ClientModel findById(Integer id) {

        try {

            logger.info("Accessing ClientDAOImpl findById");

            MapSqlParameterSource parameters = new MapSqlParameterSource()
                    .addValue(ClientMapper.ID, id);

            final KeyHolder holder = new GeneratedKeyHolder();

            String sql = "SELECT * FROM client WHERE id = :id";


            return namedJdbcTemplate.queryForObject(sql, parameters, new ClientMapper());


        } catch (Exception e) {
            logger.info("Accessing ClientDAOImpl findById error = " + e.getMessage());
        }


        return null;
    }

    @Override
    public Integer create(ClientModel clientModel) {

        try {

            logger.info("Accessing ClientDAOImpl create clientModel = " + clientModel);

            MapSqlParameterSource parameters = new MapSqlParameterSource()
                    .addValue(ClientMapper.NAME, clientModel.getName());

            final KeyHolder holder = new GeneratedKeyHolder();

            String sql = "INSERT INTO client (name) VALUES (:name);";

            namedJdbcTemplate.update(sql, parameters, holder, new String[]{ClientMapper.ID});

            return !Objects.isNull(holder.getKey()) ? holder.getKey().intValue() : null;
        } catch (Exception e) {
            logger.info("Accessing ClientDAOImpl create error = " + e.getMessage());
        }

        return null;
    }

    @Override
    public Integer update(ClientModel clientModel) {

        try {

            logger.info("Accessing ClientDAOImpl update clientModel = " + clientModel);
            MapSqlParameterSource parameters = new MapSqlParameterSource()
                    .addValue(ClientMapper.ID, clientModel.getKey())
                    .addValue(ClientMapper.NAME, clientModel.getName());

            final KeyHolder holder = new GeneratedKeyHolder();

            String sql = "UPDATE client SET NAME = :name WHERE ID = :id";

            return namedJdbcTemplate.update(sql, parameters, holder, new String[]{ClientMapper.ID});
        } catch (Exception e) {
            logger.info("Accessing ClientDAOImpl update error = " + e.getMessage());
        }

        return null;
    }

    @Override
    public Integer delete(Integer id) {

        try {

            logger.info("Accessing ClientDAOImpl delete id = " + id);

            MapSqlParameterSource parameters = new MapSqlParameterSource()
                    .addValue(ClientMapper.ID, id);

            final KeyHolder holder = new GeneratedKeyHolder();

            String sql = "DELETE FROM client WHERE ID = :id";


            return namedJdbcTemplate.update(sql, parameters, holder, new String[]{ClientMapper.ID});

        } catch (Exception e) {
            logger.info("Accessing ClientDAOImpl delete error = " + e.getMessage());
        }

        return null;
    }
}
