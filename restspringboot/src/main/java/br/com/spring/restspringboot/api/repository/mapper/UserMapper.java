package br.com.spring.restspringboot.api.repository.mapper;

import br.com.spring.restspringboot.api.model.UserModel;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<UserModel> {

    public static final String ID = "id";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String EMAIL = "email";

    @Override
    public UserModel mapRow(ResultSet resultSet, int i) throws SQLException {
        return UserModel.builder()
                .id(resultSet.getInt(ID))
                .userName(resultSet.getString(USERNAME))
                .password(resultSet.getString(PASSWORD))
                .email(resultSet.getString(EMAIL))
                .build();
    }
}
