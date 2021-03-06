package br.com.vendas.dto.cliente;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ClienteRequestDTO {

    @Size(min = 3, max = 100, message = "Minimo 3 caracter no maximo 100 caracter")
    @NotNull(message = "O nome não pode ser nulo ou vazio")
    private String nome;

    @CPF(message = "O Cpf precisa ser valido")
    @NotNull(message = "O CPF não pode ser nulo ou vazio")
    private String cpf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
