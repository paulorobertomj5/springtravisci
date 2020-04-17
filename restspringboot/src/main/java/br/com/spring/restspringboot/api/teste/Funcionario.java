package br.com.spring.restspringboot.api.teste;

public class Funcionario extends Pessoa {

    @Override
    public String work(){
        return "Mecanico";
    }
}
