package br.com.vendas.mapper;

import br.com.vendas.dto.pedido.PedidoDTO;
import br.com.vendas.model.Pedido;

public interface PedidoMapper {

    Pedido toPedido(PedidoDTO pedidoDTO);

}
