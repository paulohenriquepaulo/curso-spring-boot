package br.com.vendas.service;

import br.com.vendas.exception.ExceptionPersonalizada;
import br.com.vendas.model.Cliente;
import br.com.vendas.repostory.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente cadastrarCliente(Cliente cliente) {
        validarCPF(cliente.getCpf());
        return repository.save(cliente);
    }

    private void validarCPF(String cpf) {
        if (repository.existsByCpf(cpf)) {
            throw new ExceptionPersonalizada("erro:", "CPF já existente");
        }
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
        if (!cliente.getCpf().equalsIgnoreCase(clienteAtualizado.getCpf())){
            throw new ExceptionPersonalizada("eroo:", "O CPF não pode ser alterado.");
        }
        clienteAtualizado.setNome(cliente.getNome());
        return repository.save(clienteAtualizado);
    }
    public void deletarCliente(Integer id) {
        Cliente cliente = buscarPorId(id);
        repository.delete(cliente);
    }

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
