package br.com.spring.restspringboot.api.repository.mapper;

import br.com.spring.restspringboot.api.model.PersonModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<PersonModel> {

    public static final String ID = "id";
    public static final String NAME = "name";


    @Override
    public PersonModel mapRow(ResultSet rs, int i) throws SQLException {
        return PersonModel.builder()
                .id(rs.getInt(ID))
                .name(rs.getString(NAME))
                .build();
    }
}
