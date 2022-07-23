package br.com.vendas.service;

import br.com.vendas.model.Cliente;

import java.util.List;

public interface ClienteServece {

    Cliente cadastrarCliente(Cliente cliente);

    Cliente buscarPorId(Integer id);

    Cliente atualizarCliente(Cliente cliente);

    void deletarCliente(Integer id);

    List<Cliente> buscarClientes(Cliente cliente);
}
