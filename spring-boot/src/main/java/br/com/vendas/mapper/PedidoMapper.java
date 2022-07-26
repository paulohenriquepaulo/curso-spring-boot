package br.com.vendas.mapper;

import br.com.vendas.dto.pedido.ItemPedidoDTO;
import br.com.vendas.dto.pedido.PedidoRequestDTO;
import br.com.vendas.model.ItemPedido;
import br.com.vendas.model.Pedido;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

    Pedido toPedido(PedidoRequestDTO pedidoRequestDTO);


    List<ItemPedido> toItemPedido(List<ItemPedidoDTO> itemPedidoDTOS);


}
