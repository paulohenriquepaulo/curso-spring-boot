package br.com.vendas.service;

import br.com.vendas.exception.ExceptionPersonalizada;
import br.com.vendas.model.Cliente;
import br.com.vendas.repostory.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente cadastrarCliente(Cliente cliente) {
        return repository.save(cliente);
    }

    public Cliente buscarPorId(Integer id) {
        Optional<Cliente> cliente = repository.findById(id);
        if (!cliente.isPresent()) {
            throw new ExceptionPersonalizada("erro:", "Id invalido");
        }
        return cliente.get();
    }

    public Cliente atualizarCliente(Cliente cliente) {
        Cliente clienteAtualizado = buscarPorId(cliente.getId());
        clienteAtualizado.setNome(cliente.getNome());
        return repository.save(clienteAtualizado);
    }
    public void deletarCliente(Integer id) {
        Cliente cliente = buscarPorId(id);
        repository.delete(cliente);
    }

}
