package br.com.spring.restspringboot.api.entity.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.ResourceSupport;

@Data
@NoArgsConstructor
public class ClientResponse extends ResourceSupport {

    private Integer key;
    private String name;
}
