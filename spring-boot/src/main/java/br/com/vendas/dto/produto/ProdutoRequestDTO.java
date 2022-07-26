package br.com.vendas.dto.produto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ProdutoRequestDTO {

    @NotEmpty(message = "Descrção obrigatoria")
    private String descricao;

    @NotNull(message = "Preço obrigatorio")
    @Column(name = "preco_unitario")
    private BigDecimal preco;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
