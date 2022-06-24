package br.com.vendas.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ClienteRequestDTO {

    @Size(min = 3, max = 100, message = "Minimo 3 caracter no maximo 100 caracter")
    @NotNull(message = "O nome não pode ser nulo ou vazio")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
