package br.com.spring.restspringboot.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    private int id;
    private String userName;
    private String password;
    private String email;
}
