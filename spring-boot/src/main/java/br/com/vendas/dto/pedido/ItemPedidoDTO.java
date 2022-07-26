package br.com.vendas.dto.pedido;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ItemPedidoDTO {

    @NotNull(message = "O id do produto não pode ser nulo ou vazio.")
    private Integer id_produto;
    @Size(min = 1, message = "A quantidade precisa ser no minimo 1")
    private Integer quantidade;

    public Integer getId_produto() {
        return id_produto;
    }

    public void setId_produto(Integer id_produto) {
        this.id_produto = id_produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

}
