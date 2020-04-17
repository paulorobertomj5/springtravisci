package br.com.spring.restspringboot.api.teste;

public class Teste {
    public static void main(String[] args) {
        Pessoa pessoa = new Funcionario();
        Pessoa pessoa2 = new Padeiro();

        System.out.println(pessoa.work());
        System.out.println(pessoa2.work());
    }
}
