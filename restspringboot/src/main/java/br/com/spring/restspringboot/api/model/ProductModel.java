package br.com.spring.restspringboot.api.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductModel {
    private Integer key;
    private String name;
    private String qtd;
    private Double price;
}
