package br.com.vendas.dto.produto;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ProdutoResquestAtualizarDTO {


    @NotNull(message = "Id não pode ser nulo ou vazio")
    private Integer id;
    @NotNull(message = "Descrção obrigatoria")
    private String descricao;

    @NotNull(message = "Preço obrigatorio")
    @Column(name = "preco_unitario")
    private BigDecimal preco;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
