package br.com.vendas.service.impl;

import br.com.vendas.dto.pedido.ItemPedidoDTO;
import br.com.vendas.dto.pedido.PedidoRequestDTO;
import br.com.vendas.exception.ExceptionPersonalizada;
import br.com.vendas.mapper.PedidoMapper;
import br.com.vendas.model.Cliente;
import br.com.vendas.model.ItemPedido;
import br.com.vendas.model.Pedido;
import br.com.vendas.repostory.ClienteRepository;
import br.com.vendas.repostory.ItemPedidoRepository;
import br.com.vendas.repostory.PedidoRepository;
import br.com.vendas.repostory.ProdutoRepository;
import br.com.vendas.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private ProdutoServiceImpl produtoService;

    @Override
    @Transactional
    public Pedido salvarPedido(PedidoRequestDTO pedidoRequestDTO) {
        Cliente cliente = getCliente(pedidoRequestDTO.getId_cliente());
        validarProduto(pedidoRequestDTO.getPedidos());
        Pedido pedido = new Pedido();
        pedido.setTotal(pedidoRequestDTO.getTotal());
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente(cliente);
        List<ItemPedido> itemPedidos = converterItems(pedido, pedidoRequestDTO.getPedidos());
        pedido.setPedidos(itemPedidos);
        itemPedidoRepository.saveAll(itemPedidos);
        pedidoRepository.save(pedido);
        return pedido;
    }


    /**
     * Método para pega um cliente, caso cliente não seja
     * encontrado uma exception personalizada e disparada.
     * @param id_cliente
     * @return Cliente
     */
    private Cliente getCliente(Integer id_cliente) {
        return clienteRepository.findById(id_cliente)
                .orElseThrow(() -> new ExceptionPersonalizada("mensagem", "Cliente não encotrado"));
    }

    /**
     * Método para validar se o produto
     * da lista de pedidos existe, caso o produto não seja encontrado
     * uma exception personalizada é disparada.
     * @param pedidos
     * @return Void
     *
     */
    private void validarProduto(List<ItemPedidoDTO> pedidos) {
        pedidos.forEach(p -> produtoRepository.findById(p.getId_produto())
                .orElseThrow(() -> new  ExceptionPersonalizada("mensagem", "Produto " + p.getId_produto() + " não cadastrado")));

    }

    private List<ItemPedido> converterItems(Pedido pedido, List<ItemPedidoDTO> itemsPedidoDTOS) {
        if (itemsPedidoDTOS.isEmpty()) {
            throw new ExceptionPersonalizada("mensagem", "Não é possivel realizar um pedido sem intens.");
        }
        return itemsPedidoDTOS
                .stream()
                .map(dto -> {
                    ItemPedido itemPedido = new ItemPedido();
                    itemPedido.setQuantidade(dto.getQuantidade());
                    itemPedido.setPedido(pedido);
                    itemPedido.setProduto(produtoService.buscarPorId(dto.getId_produto()));
                    return itemPedido;
                }).collect(Collectors.toList());
    }


}
