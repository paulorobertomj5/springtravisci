package br.com.spring.restspringboot.api.repository;

import br.com.spring.restspringboot.api.model.UserModel;

import java.util.List;

public interface UserDAO {

    List<UserModel> getUsers();

    UserModel getFindByUserName(String username);
}
