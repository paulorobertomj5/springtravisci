package br.com.spring.restspringboot.api.repository.mapper;

import br.com.spring.restspringboot.api.model.ProductModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<ProductModel> {

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String QTD = "qtd";
    public static final String PRICE = "price";


    @Override
    public ProductModel mapRow(ResultSet rs, int i) throws SQLException {
        return ProductModel.builder()
                .key(rs.getInt(ID))
                .name(rs.getString(NAME))
                .qtd(rs.getString(QTD))
                .price(rs.getDouble(PRICE))
                .build();
    }
}
