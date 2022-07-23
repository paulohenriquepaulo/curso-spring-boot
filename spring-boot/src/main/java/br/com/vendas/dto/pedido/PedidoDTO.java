package br.com.vendas.dto.pedido;

import java.math.BigDecimal;
import java.util.List;

public class PedidoDTO {

    private Integer id_cliente;

    private BigDecimal total;

    private List<ItemPedidoDTO> pedidos;

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<ItemPedidoDTO> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<ItemPedidoDTO> pedidos) {
        this.pedidos = pedidos;
    }
}
