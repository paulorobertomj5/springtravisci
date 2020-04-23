package br.com.spring.restspringboot.api.repository.impl;

import br.com.spring.restspringboot.api.model.OrderModel;
import br.com.spring.restspringboot.api.repository.OrderDAO;
import br.com.spring.restspringboot.api.repository.mapper.OrderMapper;
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
public class OrderDAOImpl implements OrderDAO {

    @Autowired
    private DataSource dataSource;

    private NamedParameterJdbcTemplate namedJdbcTemplate;


    Logger logger = LoggerFactory.getLogger(OrderDAOImpl.class);

    @PostConstruct
    private void postConstruct() {

        namedJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<OrderModel> findAll() {

        try {
            logger.info("Accessing OrderDAOImpl findAll ");

            String sql = "SELECT * FROM orders";
            return namedJdbcTemplate.query(sql, new OrderMapper());

        } catch (Exception e) {
            logger.info("Accessing OrderDAOImpl findAll error = " + e.getMessage());
        }

        return new ArrayList<>();
    }

    @Override
    public OrderModel findByClientId(Integer clientId) {

        try {

            logger.info("Accessing OrderDAOImpl findByClientId clientId =" + clientId);
            MapSqlParameterSource parameters = new MapSqlParameterSource()
                    .addValue(OrderMapper.CLIENT_ID, clientId);

            final KeyHolder holder = new GeneratedKeyHolder();

            String sql = "SELECT * FROM orders WHERE client_id = :client_id";


            return namedJdbcTemplate.queryForObject(sql, parameters, new OrderMapper());


        } catch (Exception e) {
            logger.info("Accessing OrderDAOImpl findByClientId error = " + e.getMessage());
        }

        return null;
    }

    @Override
    public OrderModel findById(Integer id) {

        try {

            logger.info("Accessing OrderDAOImpl findById id =" + id);
            MapSqlParameterSource parameters = new MapSqlParameterSource()
                    .addValue(OrderMapper.ID, id);

            final KeyHolder holder = new GeneratedKeyHolder();

            String sql = "SELECT * FROM orders WHERE id = :id";


            return namedJdbcTemplate.queryForObject(sql, parameters, new OrderMapper());


        } catch (Exception e) {
            logger.info("Accessing OrderDAOImpl findByClientId error = " + e.getMessage());
        }

        return null;
    }

    @Override
    public Integer create(OrderModel orderModel) {

        try {

            logger.info("Accessing OrderDAOImpl create orderModel =" + orderModel);

            MapSqlParameterSource parameters = new MapSqlParameterSource()
                    .addValue(OrderMapper.CLIENT_ID, orderModel.getClientId())
                    .addValue(OrderMapper.PRODUCT_ID, orderModel.getProductId())
                    .addValue(OrderMapper.QTD, orderModel.getQtd())
                    .addValue(OrderMapper.PRICE, orderModel.getPrice());

            final KeyHolder holder = new GeneratedKeyHolder();

            String sql = "INSERT INTO orders (client_id, product_id,qtd, price) VALUES (:client_id, :product_id, :qtd, :price);";


            namedJdbcTemplate.update(sql, parameters, holder, new String[]{OrderMapper.ID});
            return !Objects.isNull(holder.getKey()) ? holder.getKey().intValue() : null;


        } catch (Exception e) {
            logger.info("Accessing OrderDAOImpl create error = " + e.getMessage());
        }

        return null;
    }

    @Override
    public Integer update(OrderModel orderModel) {

        try {

            logger.info("Accessing OrderDAOImpl update orderModel =" + orderModel);

            MapSqlParameterSource parameters = new MapSqlParameterSource()
                    .addValue(OrderMapper.ID, orderModel.getKey())
                    .addValue(OrderMapper.CLIENT_ID, orderModel.getClientId())
                    .addValue(OrderMapper.PRODUCT_ID, orderModel.getProductId())
                    .addValue(OrderMapper.QTD, orderModel.getQtd())
                    .addValue(OrderMapper.PRICE, orderModel.getPrice());

            final KeyHolder holder = new GeneratedKeyHolder();

            String sql = "UPDATE orders SET CLIENT_ID = :client_id,PRODUCT_ID = :product_id, QTD = :qtd, PRICE = :price WHERE ID = :id";


            return namedJdbcTemplate.update(sql, parameters, holder, new String[]{OrderMapper.ID});

        } catch (Exception e) {
            logger.info("Accessing OrderDAOImpl update error = " + e.getMessage());
        }

        return null;
    }

    @Override
    public Integer delete(Integer id) {
        try {

            logger.info("Accessing OrderDAOImpl delete id =" + id);

            MapSqlParameterSource parameters = new MapSqlParameterSource()
                    .addValue(OrderMapper.ID, id);

            final KeyHolder holder = new GeneratedKeyHolder();

            String sql = "DELETE FROM orders WHERE ID = :id";


            return namedJdbcTemplate.update(sql, parameters, holder, new String[]{OrderMapper.ID});

        } catch (Exception e) {
            logger.info("Accessing OrderDAOImpl delete error = " + e.getMessage());
        }

        return null;
    }
}
