package br.com.spring.restspringboot.api.entity.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class OrderRequest {

    private Integer key;

    @NotNull
    @Valid
    private Integer clientId;

    @NotNull
    @Valid
    private Integer productId;

    @NotNull
    @Valid
    private Integer qtd;

    @NotNull
    @Valid
    private Double price;

}
