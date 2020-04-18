package br.com.spring.restspringboot.api.service;

import br.com.spring.restspringboot.api.entity.UserEntity;

import java.util.List;

public interface UserService {

    public List<UserEntity> getUsers();
}
