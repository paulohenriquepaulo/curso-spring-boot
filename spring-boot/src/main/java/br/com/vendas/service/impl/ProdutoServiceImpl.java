package br.com.vendas.service.impl;

import br.com.vendas.exception.ExceptionPersonalizada;
import br.com.vendas.mapper.ProdutoMapper;
import br.com.vendas.model.Produto;
import br.com.vendas.repostory.ProdutoRepository;
import br.com.vendas.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private ProdutoMapper mapper;

    @Override
    public Produto cadastrarProduto(Produto toProduto) {
        return repository.save(toProduto);
    }

    @Override
    public Produto buscarPorId(Integer id) {
        Produto produto = repository.findById(id).orElseThrow(() ->
                new ExceptionPersonalizada("mensagem", "Produto não encontrado"));
        return produto;
    }

    @Override
    public Produto atualizarProduto(Produto produto) {
        Produto produtoAtualizado = buscarPorId(produto.getId());
        produtoAtualizado = mapper.toProduto(produto);
        return repository.save(produtoAtualizado);
    }

    @Override
    public void deletarProduto(Integer id) {
       Produto produto = buscarPorId(id);
       repository.delete(produto);
    }

    @Override
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
