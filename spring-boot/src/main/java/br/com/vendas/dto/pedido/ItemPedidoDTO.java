package br.com.vendas.dto.pedido;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemPedidoDTO {

    private Integer id_produto;

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
