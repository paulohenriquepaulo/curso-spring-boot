package br.com.vendas.service;

import br.com.vendas.dto.pedido.PedidoDTO;
import br.com.vendas.model.Pedido;

public interface PedidoService {
    Pedido salvarPedido(PedidoDTO pedidoDTO);

}
