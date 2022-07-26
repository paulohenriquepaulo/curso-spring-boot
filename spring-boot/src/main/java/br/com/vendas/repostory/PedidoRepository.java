package br.com.vendas.repostory;

import br.com.vendas.model.Cliente;
import br.com.vendas.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    List<Pedido> findByCliente(Cliente cliente);


}
