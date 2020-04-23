package br.com.spring.restspringboot.api.entity.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.ResourceSupport;

@Data
@NoArgsConstructor
public class ProductResponse extends ResourceSupport {


    private Integer key;
    private String name;
    private String qtd;
    private Double price;
}
