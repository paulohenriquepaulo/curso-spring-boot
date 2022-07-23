package br.com.vendas.service.impl;

import br.com.vendas.dto.pedido.ItemPedidoDTO;
import br.com.vendas.dto.pedido.PedidoDTO;
import br.com.vendas.exception.ExceptionPersonalizada;
import br.com.vendas.model.Cliente;
import br.com.vendas.model.Pedido;
import br.com.vendas.repostory.ClienteRepository;
import br.com.vendas.repostory.PedidoRepository;
import br.com.vendas.repostory.ProdutoRepository;
import br.com.vendas.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public Pedido salvarPedido(PedidoDTO pedidoDTO) {
        Cliente cliente = getCliente(pedidoDTO.getId_cliente());
        validarProduto(pedidoDTO.getPedidos());
        Pedido pedido = new Pedido();
        pedido.setTotal(pedidoDTO.getTotal());
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente(cliente);

        return pedidoRepository.save(pedido);
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
}
