package br.com.spring.restspringboot.api.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientModel {
    private Integer key;
    private String name;
}
