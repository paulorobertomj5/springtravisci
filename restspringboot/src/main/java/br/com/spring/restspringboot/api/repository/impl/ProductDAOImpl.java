package br.com.spring.restspringboot.api.repository.impl;

import br.com.spring.restspringboot.api.model.ProductModel;
import br.com.spring.restspringboot.api.repository.ProductDAO;
import br.com.spring.restspringboot.api.repository.mapper.ProductMapper;
import br.com.spring.restspringboot.api.service.impl.ClientServiceImpl;
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
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private DataSource dataSource;

    private NamedParameterJdbcTemplate namedJdbcTemplate;

    Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);


    @PostConstruct
    private void postConstruct() {

        namedJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public List<ProductModel> findAll() {

        try {
            logger.info("Accessing ProductDAOImpl findAll");

            String sql = "SELECT * FROM product";
            return namedJdbcTemplate.query(sql, new ProductMapper());

        } catch (Exception e) {
            logger.error("Accessing ProductDAOImpl findAll error " + e.getMessage());
        }

        return new ArrayList<>();
    }

    @Override
    public ProductModel findById(Integer id) {

        try {

            logger.info("Accessing ProductDAOImpl findById id = " + id);

            MapSqlParameterSource parameters = new MapSqlParameterSource()
                    .addValue(ProductMapper.ID, id);

            final KeyHolder holder = new GeneratedKeyHolder();

            String sql = "SELECT * FROM product WHERE id = :id";


            return namedJdbcTemplate.queryForObject(sql, parameters, new ProductMapper());

        } catch (Exception e) {
            logger.error("Accessing ProductDAOImpl findById error " + e.getMessage());
        }

        return null;
    }

    @Override
    public Integer create(ProductModel productModel) {

        try {

            logger.info("Accessing ProductDAOImpl create productModel = " + productModel);

            MapSqlParameterSource parameters = new MapSqlParameterSource()
                    .addValue(ProductMapper.NAME, productModel.getName())
                    .addValue(ProductMapper.QTD, productModel.getQtd())
                    .addValue(ProductMapper.PRICE, productModel.getPrice());

            final KeyHolder holder = new GeneratedKeyHolder();

            String sql = "INSERT INTO product (name, qtd, price) VALUES (:name, :qtd, :price);";

            namedJdbcTemplate.update(sql, parameters, holder, new String[]{ProductMapper.ID});
            return !Objects.isNull(holder.getKey()) ? holder.getKey().intValue() : null;


        } catch (Exception e) {
            logger.error("Accessing ProductDAOImpl create error " + e.getMessage());
        }

        return null;
    }

    @Override
    public Integer update(ProductModel productModel) {
        try {

            logger.info("Accessing ProductDAOImpl update productModel = " + productModel);

            MapSqlParameterSource parameters = new MapSqlParameterSource()
                    .addValue(ProductMapper.ID, productModel.getKey())
                    .addValue(ProductMapper.NAME, productModel.getName())
                    .addValue(ProductMapper.QTD, productModel.getQtd())
                    .addValue(ProductMapper.PRICE, productModel.getPrice());

            final KeyHolder holder = new GeneratedKeyHolder();

            String sql = "UPDATE product SET NAME = :name, QTD = :qtd, PRICE = :price WHERE ID = :id";


            return namedJdbcTemplate.update(sql, parameters, holder, new String[]{ProductMapper.ID});

        } catch (Exception e) {
            logger.error("Accessing ProductDAOImpl update error " + e.getMessage());
        }

        return null;
    }

    @Override
    public Integer delete(Integer id) {

        try {

            logger.info("Accessing ProductDAOImpl delete id = " + id);

            MapSqlParameterSource parameters = new MapSqlParameterSource()
                    .addValue(ProductMapper.ID, id);

            final KeyHolder holder = new GeneratedKeyHolder();

            String sql = "DELETE FROM product WHERE ID = :id";


            return namedJdbcTemplate.update(sql, parameters, holder, new String[]{ProductMapper.ID});

        } catch (Exception e) {
            logger.error("Accessing ProductDAOImpl delete error " + e.getMessage());
        }

        return null;
    }
}
