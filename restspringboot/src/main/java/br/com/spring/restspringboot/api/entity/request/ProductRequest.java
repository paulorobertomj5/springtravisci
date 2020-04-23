package br.com.spring.restspringboot.api.entity.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class ProductRequest {

    private Integer key;

    @NotNull
    @Valid
    private String name;

    @NotNull
    @Valid
    private String qtd;

    @NotNull
    @Valid
    private Double price;
}
