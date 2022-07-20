package br.com.vendas.service;

import br.com.vendas.exception.ExceptionPersonalizada;
import br.com.vendas.mapper.ProdutoMapper;
import br.com.vendas.model.Produto;
import br.com.vendas.repostory.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private ProdutoMapper mapper;

    public Produto cadastrarProduto(Produto toProduto) {
        return repository.save(toProduto);
    }

    public Produto buscarPorId(Integer id) {
        Produto produto = repository.findById(id).orElseThrow(() ->
                new ExceptionPersonalizada("mensagem", "Produto não encontrado"));
        return produto;
    }

    public Produto atualizarProduto(Produto produto) {
        Produto produtoAtualizado = buscarPorId(produto.getId());
        produtoAtualizado = mapper.toProduto(produto);
        return repository.save(produtoAtualizado);
    }

    public void deletarProduto(Integer id) {
       Produto produto = buscarPorId(id);
       repository.delete(produto);
    }

    public List<Produto> buscarProdutoPorCriterio(Produto produto) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(produto, matcher);
        List<Produto> produtoList = repository.findAll(example);
        return  produtoList;
    }
}
