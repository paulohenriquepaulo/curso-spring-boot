package br.com.vendas.repostory;

import br.com.vendas.model.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {

    @Query(value = "SELECT p FROM ItemPedido p WHERE id_pedido = :id_pedido ")
    List<ItemPedido> findByIdPedido(@Param("id_pedido") Integer id_pedido);
}
