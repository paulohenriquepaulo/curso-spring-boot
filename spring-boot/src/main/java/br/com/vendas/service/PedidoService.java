package br.com.vendas.service;

import br.com.vendas.dto.pedido.PedidoRequestDTO;
import br.com.vendas.model.Pedido;

public interface PedidoService {
    Pedido salvarPedido(PedidoRequestDTO pedidoDTO);

}
