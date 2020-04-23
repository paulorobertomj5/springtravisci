package br.com.spring.restspringboot.api.entity.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.ResourceSupport;

@Data
@NoArgsConstructor
public class OrderResponse extends ResourceSupport {


    private Integer key;
    private ClientResponse client;
    private ProductResponse product;
    private Integer qtd;
    private Double price;

}
