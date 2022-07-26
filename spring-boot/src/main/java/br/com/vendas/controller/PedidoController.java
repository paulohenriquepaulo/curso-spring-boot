package br.com.vendas.controller;

import br.com.vendas.dto.pedido.PedidoRequestDTO;
import br.com.vendas.dto.pedido.PedidoResponseDTO;
import br.com.vendas.model.Pedido;
import br.com.vendas.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {


    @Autowired
    private PedidoService pedidoService;


    @PostMapping
    public ResponseEntity<Integer> salvarPedido(@RequestBody @Valid  PedidoRequestDTO pedidoDTO) {
        Pedido pedido = pedidoService.salvarPedido(pedidoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido.getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponseDTO> buscarPedidoPorId(@PathVariable Integer id) {
        PedidoResponseDTO dto = pedidoService.recuperarPedido(id);
        return ResponseEntity.ok(dto);
    }

    @PatchMapping("{id}")
    public ResponseEntity cancelarPedido(@PathVariable Integer id) {
        pedidoService.cancelarPedido(id);
        return ResponseEntity.ok().build();
    }

}
