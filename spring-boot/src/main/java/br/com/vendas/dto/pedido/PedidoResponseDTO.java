package br.com.vendas.dto.pedido;

import java.math.BigDecimal;
import java.util.List;

public class PedidoResponseDTO {

    private Integer id_pedido;

    private String cpf_cliente;

    private String nomeCliente;

    private BigDecimal total;

    private List<InformacaoIntemPedido> items;

    public Integer getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Integer id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getCpf_cliente() {
        return cpf_cliente;
    }

    public void setCpf_cliente(String cpf_cliente) {
        this.cpf_cliente = cpf_cliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<InformacaoIntemPedido> getItems() {
        return items;
    }

    public void setItems(List<InformacaoIntemPedido> items) {
        this.items = items;
    }

}
