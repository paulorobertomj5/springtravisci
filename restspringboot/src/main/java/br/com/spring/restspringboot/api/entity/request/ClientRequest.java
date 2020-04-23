package br.com.spring.restspringboot.api.entity.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@ToString
public class ClientRequest {

    private Integer key;

    @NotNull
    @Valid
    private String name;
}
