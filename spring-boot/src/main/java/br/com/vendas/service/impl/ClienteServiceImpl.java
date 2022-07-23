package br.com.vendas.service.impl;

import br.com.vendas.exception.ExceptionPersonalizada;
import br.com.vendas.mapper.ClienteMapper;
import br.com.vendas.model.Cliente;
import br.com.vendas.repostory.ClienteRepository;
import br.com.vendas.service.ClienteServece;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteServece {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ClienteMapper mapper;

    @Override
    public Cliente cadastrarCliente(Cliente cliente) {
        validarCPF(cliente.getCpf());
        return repository.save(cliente);
    }

    private void validarCPF(String cpf) {
        if (repository.existsByCpf(cpf)) {
            throw new ExceptionPersonalizada("erro:", "CPF já existente");
        }
    }

    @Override
    public Cliente buscarPorId(Integer id) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new ExceptionPersonalizada("mensagem", "ID não encotrado."));
        return cliente;
    }

    @Override
    public Cliente atualizarCliente(Cliente cliente) {
        Cliente clienteAtualizado = buscarPorId(cliente.getId());
        if (!clienteAtualizado.getCpf().equalsIgnoreCase(cliente.getCpf())) {
            throw new ExceptionPersonalizada("mensagem", "O CPF não pode ser alterado.");
        }
        clienteAtualizado = mapper.toCliente(cliente);
        return repository.save(clienteAtualizado);
    }

    @Override
    public void deletarCliente(Integer id) {
        Cliente cliente = buscarPorId(id);
        repository.delete(cliente);
    }

    @Override
    public List<Cliente> buscarClientes(Cliente cliente) {
            ExampleMatcher matcher = ExampleMatcher
                    .matching()
                    .withIgnoreCase()
                    .withStringMatcher(
                            ExampleMatcher.StringMatcher.CONTAINING);
            Example example = Example.of(cliente, matcher);
            List<Cliente> clienteList = repository.findAll(example);
            return clienteList;
    }
}
