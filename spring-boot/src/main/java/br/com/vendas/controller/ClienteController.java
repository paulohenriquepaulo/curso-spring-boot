package br.com.vendas.controller;

import br.com.vendas.dto.ClienteBuscarDTO;
import br.com.vendas.dto.ClienteRequestDTO;
import br.com.vendas.dto.ClienteResponseDTO;
import br.com.vendas.dto.ClienteResquestAtualizarDto;
import br.com.vendas.mapper.ClienteMapper;
import br.com.vendas.model.Cliente;
import br.com.vendas.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteMapper mapper;

    @Autowired
    private ClienteService service;

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> cadastrarCliente(@RequestBody @Valid ClienteRequestDTO clienteDTO) {
        Cliente novoCliente = service.cadastrarCliente(mapper.toCliente(clienteDTO));
        return ResponseEntity.ok(mapper.toClienteResponseDto(novoCliente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> buscarPorId(@PathVariable Integer id) {
        Cliente cliente = service.buscarPorId(id);
        return ResponseEntity.ok(mapper.toClienteResponseDto(cliente));
    }

    @PutMapping
    public ResponseEntity<ClienteResponseDTO> atualizarCliente(@RequestBody @Valid ClienteResquestAtualizarDto clienteDTO) {
        Cliente novoCliente = service.atualizarCliente(mapper.toCliente(clienteDTO));
        return ResponseEntity.ok(mapper.toClienteResponseDto(novoCliente));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deletarCliente(@PathVariable Integer id) {
        service.deletarCliente(id);
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity buscarCliente(ClienteBuscarDTO clienteBuscarDTO) {
        List<Cliente> clienteList = service.buscarClientes(mapper.toCliente(clienteBuscarDTO));
        return ResponseEntity.ok(clienteList);
    }

}
