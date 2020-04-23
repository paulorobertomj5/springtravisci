package br.com.spring.restspringboot.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderModel {
    private Integer key;
    @JsonProperty("client_id")
    private Integer clientId;
    @JsonProperty("product_id")
    private Integer productId;
    private Integer qtd;
    private Double price;
}
