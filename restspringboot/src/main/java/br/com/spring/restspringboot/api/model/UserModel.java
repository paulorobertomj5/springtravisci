package br.com.spring.restspringboot.api.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserModel {
    private int id;
    private String userName;
    private String password;
    private String email;
}
