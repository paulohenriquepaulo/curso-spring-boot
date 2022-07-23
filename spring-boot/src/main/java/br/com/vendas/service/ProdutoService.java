package br.com.vendas.service;

import br.com.vendas.model.Produto;

import java.util.List;

public interface ProdutoService {

    Produto cadastrarProduto(Produto toProduto);

    Produto buscarPorId(Integer id);

    Produto atualizarProduto(Produto produto);

    void deletarProduto(Integer id);

    List<Produto> buscarProdutoPorCriterio(Produto produto);
}
