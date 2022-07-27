package br.com.vendas.dto.produto;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProdutoRequestDTO {

    @NotEmpty(message = "Descrção obrigatoria")
    private String descricao;

    @NotNull(message = "Preço obrigatorio")
    @Column(name = "preco_unitario")
    private Double preco;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
