package br.com.vendas.service;

import br.com.vendas.dto.pedido.PedidoRequestDTO;
import br.com.vendas.dto.pedido.PedidoResponseDTO;
import br.com.vendas.model.Pedido;

public interface PedidoService {
    Pedido salvarPedido(PedidoRequestDTO pedidoDTO);

    PedidoResponseDTO recuperarPedido(Integer id_pedido);

    void cancelarPedido(Integer id_pedido);

}
