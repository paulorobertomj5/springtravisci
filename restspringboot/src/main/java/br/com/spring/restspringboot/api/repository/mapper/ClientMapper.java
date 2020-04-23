package br.com.spring.restspringboot.api.repository.mapper;

import br.com.spring.restspringboot.api.model.ClientModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientMapper implements RowMapper<ClientModel> {

    public static final String ID = "id";
    public static final String NAME = "name";


    @Override
    public ClientModel mapRow(ResultSet rs, int i) throws SQLException {
        return ClientModel.builder()
                .key(rs.getInt(ID))
                .name(rs.getString(NAME))
                .build();
    }
}
