package br.com.vendas.mapper;

import br.com.vendas.dto.produto.ProdutoBuscarDTO;
import br.com.vendas.dto.produto.ProdutoRequestDTO;
import br.com.vendas.dto.produto.ProdutoResponseDTO;
import br.com.vendas.dto.produto.ProdutoResquestAtualizarDTO;
import br.com.vendas.model.Produto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    Produto toProduto (ProdutoRequestDTO produtoRequestDTO);

    Produto toProduto (Produto produto);

    Produto toProduto (ProdutoBuscarDTO produtoBuscarDTOroduto);

    Produto toProduto (ProdutoResquestAtualizarDTO produtoResquestAtualizarDTO);

    ProdutoResponseDTO toProdutoResponseDTO(Produto produto);

    List<ProdutoResponseDTO> toProdutoResponseDTO(List<Produto> produtoList);
}
