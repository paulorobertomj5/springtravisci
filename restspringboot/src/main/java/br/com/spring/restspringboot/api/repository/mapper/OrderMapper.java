package br.com.spring.restspringboot.api.repository.mapper;

import br.com.spring.restspringboot.api.model.OrderModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<OrderModel> {

    public static final String ID = "id";
    public static final String CLIENT_ID = "client_id";
    public static final String PRODUCT_ID = "product_id";
    public static final String QTD = "qtd";
    public static final String PRICE = "price";


    @Override
    public OrderModel mapRow(ResultSet rs, int i) throws SQLException {
        return OrderModel.builder()
                .key(rs.getInt(ID))
                .clientId(rs.getInt(CLIENT_ID))
                .productId(rs.getInt(PRODUCT_ID))
                .qtd(rs.getInt(QTD))
                .price(rs.getDouble(PRICE))
                .build();
    }
}
