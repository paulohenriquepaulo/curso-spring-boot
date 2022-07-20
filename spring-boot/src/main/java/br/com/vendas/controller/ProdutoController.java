package br.com.vendas.controller;

import br.com.vendas.dto.produto.ProdutoBuscarDTO;
import br.com.vendas.dto.produto.ProdutoRequestDTO;
import br.com.vendas.dto.produto.ProdutoResponseDTO;
import br.com.vendas.dto.produto.ProdutoResquestAtualizarDTO;
import br.com.vendas.mapper.ProdutoMapper;
import br.com.vendas.model.Produto;
import br.com.vendas.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {


    @Autowired
    private ProdutoService service;

    @Autowired
    private ProdutoMapper mapper;


    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> cadastrarProduto(@RequestBody @Valid ProdutoRequestDTO produtoRequestDTO) {
        Produto produtoNovo = service.cadastrarProduto(mapper.toProduto(produtoRequestDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toProdutoResponseDTO(produtoNovo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> buscarProdutoPorId(@PathVariable Integer id) {
        Produto produto = service.buscarPorId(id);
        return ResponseEntity.ok(mapper.toProdutoResponseDTO(produto));
    }

    @PutMapping
    public ResponseEntity<ProdutoResponseDTO> atualizarProduto(@RequestBody @Valid ProdutoResquestAtualizarDTO atualizarDTO) {
        Produto produtoAtualizado = service.atualizarProduto(mapper.toProduto(atualizarDTO));
        return ResponseEntity.ok(mapper.toProdutoResponseDTO(produtoAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarProdutoPorId(@PathVariable Integer id) {
        service.deletarProduto(id);
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<?> buscarProdutoPorCriterio(ProdutoBuscarDTO produtoBuscarDTO) {
        List<Produto>  produtoDTOList = service.buscarProdutoPorCriterio(mapper.toProduto(produtoBuscarDTO));
        List<ProdutoResponseDTO> produtoResponseDTOS = mapper.toProdutoResponseDTO(produtoDTOList);
        return ResponseEntity.ok(produtoResponseDTOS);
    }

}
