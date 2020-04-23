package br.com.spring.restspringboot.api.entity.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private int id;
    private String userName;
    private String password;
    private String email;

    @Data
    @NoArgsConstructor
    public static class ClientResponse {


        @NotNull
        @Valid
        private Integer id;

        @NotNull
        @Valid
        private String name;
    }
}
