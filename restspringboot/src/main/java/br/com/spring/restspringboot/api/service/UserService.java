package br.com.spring.restspringboot.api.service;

import br.com.spring.restspringboot.api.entity.response.UserResponse;

import java.util.List;

public interface UserService {

    public List<UserResponse> getUsers();
}
